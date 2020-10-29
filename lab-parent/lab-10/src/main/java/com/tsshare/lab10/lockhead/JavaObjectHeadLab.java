package com.tsshare.lab10.lockhead;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author chenzhenfei
 * @title: JavaObjectHeadLab
 * @projectName framework-lab
 * @description: java 对象头显示
 * @date 2020/10/2821:12
 */
public class JavaObjectHeadLab {

    public static void main(String[] args) {
        new JavaObjectHeadLab().test();
    }

    private void test() {
        A a = new A();
        // 查看对象的整体结构信息
        synchronized (a) {
            Long id = Thread.currentThread().getId();
            System.out.println(Integer.parseInt(id.toString(), 2));
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }

    class A{
        public A() {
            
        }
    }
}
