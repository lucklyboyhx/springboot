package com.example.MySpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */

@ComponentScan(basePackages={"com.example.MySpringBoot"})
//Spring Boot 应用的标识
@SpringBootApplication
@EnableAutoConfiguration
//dao 接口类扫描包配置
@MapperScan("com.example.MySpringBoot.dao")
public class Application extends SpringBootServletInitializer{

    
	@Bean
    public SpringContextHolder pringContextHolder() {
        return new SpringContextHolder();
    }

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Application.class);
    }
	
    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
    	ApplicationContext ctx = SpringApplication.run(Application.class,args);
    	SpringContextHolder springContextHolder = new SpringContextHolder();
    	springContextHolder.setApplicationContext(ctx);
    }
    
}
