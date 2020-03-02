package org.poem;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author poem
 */
@EnableSwagger2
@EnableKnife4j
@EnableDiscoveryClient
@SpringBootApplication
public class Knife4jBaseApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(Knife4jBaseApplication.class, args);
    }
}
