package springbasic.customaop.member.serviceimpl.ver5;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springbasic.customaop.logger.MyLogger;
import springbasic.customaop.member.MemberService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Service("factoryBeanDynamicProxy")
public class MemberServiceDynamicProxy implements InvocationHandler {

    MyLogger logger = new MyLogger();
    MemberService target;

    public MemberServiceDynamicProxy(@Qualifier("factoryBeanVer") MemberService service) {
        this.target = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.start();
        Object obj = method.invoke(target, args);
        logger.end();

        return obj;
    }
}

