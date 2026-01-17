package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final AppProperties appProperties;
    private final String basePath;

    public AppConfig(AppProperties appProperties, @Value("${api.base-path}") String basePath) {
        this.appProperties = appProperties;
        this.basePath = basePath;
    }
}
