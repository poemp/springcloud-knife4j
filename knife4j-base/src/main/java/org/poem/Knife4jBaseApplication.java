package org.poem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author poem
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Knife4jBaseApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(Knife4jBaseApplication.class, args);
    }
}
