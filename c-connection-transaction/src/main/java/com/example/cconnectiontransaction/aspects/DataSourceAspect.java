package com.example.cconnectiontransaction.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Collections;

@Aspect
@Component
public class DataSourceAspect {
    @Around("target(javax.sql.DataSource)")
    public Object aroundTransaction(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("DataSource Trace: "+ joinPoint.getSignature());
        System.out.println();
        Object object= joinPoint.proceed();
        if(object instanceof Connection){
            return createConnectionProxy((Connection) object);
        }
        else
            return object;
    }

    private Connection createConnectionProxy(Connection connection){
        return (Connection) Proxy.newProxyInstance(
                DataSourceAspect.class.getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionInvocationHandler(connection)
        );
    }
}
