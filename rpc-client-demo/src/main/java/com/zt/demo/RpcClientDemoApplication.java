package com.zt.demo;

import com.zt.rpc.autoconfigure.EnableRpcClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRpcClient
public class RpcClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcClientDemoApplication.class, args);
    }

}
