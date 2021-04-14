package springbasic.customaop.member.serviceimpl.ver4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springbasic.customaop.logger.MyLogger;
import springbasic.customaop.member.MemberService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Service
public class MemberServiceDynamicProxy implements InvocationHandler {

    MyLogger logger = new MyLogger();
    MemberService target;

    public MemberServiceDynamicProxy(@Qualifier("dynamicProxyVer") MemberService service) {
        this.target = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.start();
        Object obj = method.invoke(target, args);
        logger.end();

        System.out.println("invoke result obj : "+obj);

        return null;
    }
}

