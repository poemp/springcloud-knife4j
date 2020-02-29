package org.poem.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author poem
 */
@Configuration
@RefreshScope
@Data
public class NacosConfig {

    @Value("${app.name}")
    private String appName;
}
