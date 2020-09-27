package com.tsshare.lab08;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.adapter.AdvisorAdapter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

/**
 * @author chenzhenfei
 * @title: FactoryBeanDemo
 * @projectName framework-lab
 * @description: TODO
 * @date 2020/9/2422:42
 */
public class FactoryBeanDemo {
    public static void main(String[] args) {
        FactoryBean factoryBean =new FactoryBean() {
            @Override
            public Object getObject() throws Exception {
                return null;
            }

            @Override
            public Class<?> getObjectType() {
                return null;
            }
        };

        AdvisorAdapter advisorAdapter =new AdvisorAdapter() {
            @Override
            public boolean supportsAdvice(Advice advice) {
                return false;
            }

            @Override
            public MethodInterceptor getInterceptor(Advisor advisor) {
                return null;
            }
        };


    }
}
