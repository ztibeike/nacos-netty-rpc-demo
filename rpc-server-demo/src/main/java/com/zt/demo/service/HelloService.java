package com.zt.demo.service;

import com.zt.rpc.annotation.RpcServerService;

@RpcServerService
public class HelloService {

    public String hello(String name) {
        return "hello " + name;
    }

}
