package com.eyang.yangojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.eyang.yangojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.eyang")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.eyang.yangojbackendserviceclient.service"})
public class YangojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangojBackendUserServiceApplication.class, args);
    }

}
