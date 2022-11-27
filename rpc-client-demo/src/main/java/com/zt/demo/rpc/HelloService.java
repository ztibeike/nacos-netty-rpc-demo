package com.zt.demo.rpc;

import com.zt.rpc.annotation.RpcClientService;

@RpcClientService(service = "rpc-server-demo-service")
public interface HelloService {
    String hello(String name);
}
