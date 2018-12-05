package cn.onuo.backend.common.config;

import cn.onuo.backend.common.jwt.JwtAuthenticationEntryPoint;
import cn.onuo.backend.common.jwt.JwtAuthenticationFilter;
import cn.onuo.backend.sys.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author edward on 2018/5/29.
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Resource
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    @Override
    public UserDetailsServiceImpl userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                // 自定义获取用户信息
                .userDetailsService(this.userDetailsService())
                // 设置密码加密
                .passwordEncoder(this.passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http)
            throws Exception {
        http    // 关闭cors验证
                .cors().disable()
                // 关闭csrf验证
                .csrf().disable()
                // 无状态Session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 异常处理
                .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and()
                // 对所有的请求都做权限校验
                .authorizeRequests()

                .antMatchers(
                        "/druid/**"
                ).permitAll()

                .antMatchers(
                        "/user/**"
                ).permitAll()
                // 允许匿名请求
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-ui.html**",
                        "/swagger-resources**",
                        "/webjars/**",
                        "/v2/**",
                        "/sys/user/**"
                ).permitAll()
                // 允许登录和注册
                .antMatchers(
                        HttpMethod.POST,
                        "/sys/user/token"
                ).permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/car/**"
                ).permitAll()
                .antMatchers(
                        HttpMethod.POST,
                        "/car/**"
                ).permitAll()

                .antMatchers(
                        HttpMethod.GET,
                        "/company/**"
                ).permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/order/**"
                ).permitAll()
                .antMatchers(
                HttpMethod.GET,
                "/general/**"
                ).permitAll()
                .antMatchers(
                        HttpMethod.POST,
                        "/sys/user/token"
                ).permitAll()

                // 允许登录和注册
                .antMatchers(
                        HttpMethod.POST,
                        "/sys/user/token"
                ).permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/company/info/**"
                ).permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated().and();

        http    // 基于定制JWT安全过滤器
                .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        // 禁用页面缓存
        http.headers().cacheControl();
    }
}
