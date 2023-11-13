package com.yi.puiz.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.yi.puiz.mapper")
public class DatabaseConfig {
}