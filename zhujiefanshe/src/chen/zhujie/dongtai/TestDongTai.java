package chen.zhujie.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * 陈宇超
 * 14:20
 */
public class TestDongTai {
    public static void main(String[] args) {
        serviceImpl service = new serviceImpl();

        Service myProxyInstance = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new MyInvocationHandler(service));

        myProxyInstance.doOther();
        myProxyInstance.doSome();


    }
}

interface Service {
    public void doSome();

    public void doOther();

}

class serviceImpl implements Service {

    @Override
    public void doSome() {
        System.out.println("do some");
    }

    @Override
    public void doOther() {
        System.out.println("do other");
    }
}

class MyInvocationHandler  implements InvocationHandler  {

    private Service service;

    public MyInvocationHandler(Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录了日志："+ new Date());

        method.invoke(service,args);

        System.out.println("方法执行结束了，提交事务！");
        return null;

    }
}

