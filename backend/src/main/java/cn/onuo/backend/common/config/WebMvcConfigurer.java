package cn.onuo.backend.common.config;

import cn.onuo.backend.common.entity.JsonResult;
import cn.onuo.backend.common.entity.ResponseCode;
import cn.onuo.backend.common.exception.ServiceException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author edward on 2018/5/8.
 *
 * Spring MVC 配置
 */
@Configuration
@Slf4j
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Value("${spring.profiles.active}")
    private String env;//当前激活的配置文件

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
/**/
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        // 解决 SWAGGER 404报错
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        /**/

        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }

    //使用阿里 FastJson 作为JSON MessageConverter
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,//保留空的字段
                SerializerFeature.WriteNullStringAsEmpty,//String null -> ""
                SerializerFeature.WriteNullNumberAsZero);//Number null -> 0
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }


    //统一异常处理
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add( (HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)-> {
            JsonResult result = new JsonResult();
            if (e instanceof ServiceException) {//业务失败的异常
                result.setCode(ResponseCode.FAIL).setMessage(e.getMessage());
                log.info(e.getMessage());
            } else if (e instanceof NoHandlerFoundException) {
                result.setCode(ResponseCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
            } else if (e instanceof ServletException) {
                result.setCode(ResponseCode.FAIL).setMessage(e.getMessage());
            } else {
                result.setCode(ResponseCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
                String message;
                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;
                    message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                            request.getRequestURI(),
                            handlerMethod.getBean().getClass().getName(),
                            handlerMethod.getMethod().getName(),
                            e.getMessage());
                } else {
                    message = e.getMessage();
                }
                log.error(message, e);
            }
            // json格式返回异常信息
            responseResult(response, result);
            return new ModelAndView();
        });
    }

    private void responseResult(HttpServletResponse response, JsonResult result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

    //解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    /**
     *  文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){

        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("1024MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400MB");
        return factory.createMultipartConfig();

    }



}
