package com.zfc.study.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class OrderServiceCenterProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceCenterProviderApplication.class, args);
    }

}
