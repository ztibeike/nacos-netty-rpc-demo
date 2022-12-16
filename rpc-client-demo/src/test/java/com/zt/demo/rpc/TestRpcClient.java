package com.zt.demo.rpc;

import com.zt.rpc.client.RpcClientCallBack;
import com.zt.rpc.client.RpcClientFuture;
import com.zt.rpc.client.RpcClientTemplate;
import com.zt.rpc.dto.RpcResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
public class TestRpcClient {

    // To avoid error reporting of IDEA, set required to false
    @Autowired
    private HelloService helloService;

    @Autowired
    private RpcClientTemplate rpcClientTemplate;

    @Test
    public void test() {
        System.out.println(helloService.hello("ZT"));
    }

    @Test
    public void testTemplateSync() {
        String res = (String) rpcClientTemplate.request("rpc-server-demo-service", "HelloService", "hello", "ZT").sync();
        System.out.println(res);
    }

    @Test
    public void testTemplateAsync() {
        RpcClientFuture future = rpcClientTemplate.request("rpc-server-demo-service", "HelloService", "hello", "ZT").async();
        System.out.println("test async");
        String res = (String) future.get();
        System.out.println(res);
    }

    @Test
    public void testTemplateAsyncCallBack() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        RpcClientCallBack callBack = new RpcClientCallBack() {
            @Override
            public void success(RpcResponse rpcResponse) {
                String res = (String) rpcResponse.getResult();
                System.out.println(res);
                countDownLatch.countDown();
            }
            @Override
            public void error(Throwable e) {
                System.out.println(e.getMessage());
            }
        };
        rpcClientTemplate.request("rpc-server-demo-service", "HelloService", "hello", "ZT").async(callBack);
        System.out.println("waiting for response");
    }

}
