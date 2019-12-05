package com.touchme.agentpay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.touchme.agentpay.mapper")
public class AgentpayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentpayApplication.class, args);
    }

}
