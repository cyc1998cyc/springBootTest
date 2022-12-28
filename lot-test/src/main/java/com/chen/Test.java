package com.chen;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 陈宇超
 * 17:15
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("chenyuchao");
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloService helloService = (HelloService) enhancer.create();

        helloService.sayHello();
        helloService.sayOther("chenyuchao");
    }
}


class HelloService {

    public HelloService() {
        System.out.println("HelloService:构造函数执行");
    }

    public void sayHello() {
        System.out.println("HelloService:Hello World!");
    }

    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    public final void sayOther(String name) {
        System.out.println("HelloService: Hello " + name);
    }

}

class MyMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入前置通知======");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("======插入后者通知======");
        return object;
    }


}


