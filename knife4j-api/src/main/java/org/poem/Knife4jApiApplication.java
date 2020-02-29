package org.poem;

import org.poem.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author poem
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Knife4jApiApplication implements CommandLineRunner {

    @Autowired
    private NacosConfig nacosConfig;

    public static void main(String[] args) {
        SpringApplication.run(Knife4jApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(nacosConfig.getAppName());
    }
}
