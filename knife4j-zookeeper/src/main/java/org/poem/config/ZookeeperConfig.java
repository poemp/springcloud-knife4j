package org.poem.config;

import lombok.Data;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.BoundedExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author poem
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "spring.zookeeper")
public class ZookeeperConfig {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);

    private String address;

    /**
     * bean
     * @return
     */
    @Bean
    public CuratorFramework getCuratorFramework() {
        RetryPolicy retryPolicy = new BoundedExponentialBackoffRetry(1000, 3000, 3);
        logger.info("connect zookeeper: {}", this.address);
        //需要再调用其start()方法完成会话创建
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(address, retryPolicy);
        curatorFramework.start();
        return curatorFramework;
    }
}
