package com.tsshare.lab05;

/**
 * @author chenzhenfei
 * @title: FinalDemo
 * @projectName framework-lab
 * @description: 实例变量：final 累不会隐式初始化， 一般在构造器，变量定义，非静态代码块
 *               类变量(static 修饰的)： 不一样，类变量初始化只能在定义（可以隐式初始化）和static 代码块中
 * @date 2020/9/922:58
 */
public class FinalDemo {
    private static int a =0;
    private static int b;

    private final int c=0;
    private final int d ;
    private final int e=10;
    static{
//        b=0;

    }

    public FinalDemo() {
        d=15;
    }
}
