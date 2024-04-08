package com.yiu.backend.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Data JPA Bean配置
 * 启用Jpa，扫描指定包下的Repository类和指定包下的实体类
 * *当不设置的话,全部扫描. 设置之后 entity必须在此目录下面
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.yiu.backend.repository"})
@EntityScan(basePackages = "com.yiu.backend.model")
public class JpaConfig {
}
