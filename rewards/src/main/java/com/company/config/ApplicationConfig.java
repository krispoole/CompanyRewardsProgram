package com.company.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.company.repository")
@EntityScan(basePackages="com.company.entity")
public class ApplicationConfig {

}
