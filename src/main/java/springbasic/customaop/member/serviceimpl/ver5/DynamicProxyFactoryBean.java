package springbasic.customaop.member.serviceimpl.ver5;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springbasic.customaop.member.MemberService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Component
public class DynamicProxyFactoryBean implements FactoryBean<MemberService> {

    private final InvocationHandler handler;

    public DynamicProxyFactoryBean(@Qualifier("factoryBeanDynamicProxy") InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public MemberService getObject() throws Exception {
        return (MemberService) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {MemberService.class},
                handler
        );
    }

    @Override
    public Class<?> getObjectType() {
        return MemberService.class;
    }
}
