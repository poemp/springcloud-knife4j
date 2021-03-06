package org.poem;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.poem.service.DistributedLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
public class Knife4jZookeeperApplication implements CommandLineRunner {

    @Autowired
    private DistributedLockService distributedLockService;

    
    public static void main(String[] args) {
        SpringApplication.run(Knife4jZookeeperApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        distributedLockService.createLock();
    }
}
