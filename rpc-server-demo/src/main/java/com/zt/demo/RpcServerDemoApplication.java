package com.zt.demo;

import com.zt.rpc.autoconfigure.EnableRpcServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRpcServer
public class RpcServerDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcServerDemoApplication.class, args);
    }
}
