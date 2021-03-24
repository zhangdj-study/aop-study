package com.qyhy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhangdj
 * @date 2021/03/09
 */
@ComponentScan("com.qyhy")
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
