package org.poem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author poem
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Knife4jAuthApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(Knife4jAuthApplication.class, args);
    }
}
