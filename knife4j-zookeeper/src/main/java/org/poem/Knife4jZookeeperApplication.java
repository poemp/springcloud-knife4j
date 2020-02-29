package org.poem;

import org.poem.service.DistributedLockService;
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
