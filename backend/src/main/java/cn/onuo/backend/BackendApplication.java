package cn.onuo.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kaikai
 * @date 2018/09/30
 */
@SpringBootApplication
@MapperScan("cn.onuo.backend.**.dao")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
