package com.tsshare.lab06;

/**
 * @author chenzhenfei
 * @title: VolatileExample
 * @projectName framework-lab
 * @description: Volatile  jmm 内存可见性  主存和工作内存的可见性保证
 * @date 2020/9/723:57
 */
public class VolatileExample {
    private int a = 0;
    private volatile boolean flag = false;
    public void writer(){
        a = 1;          //1
        flag = true;   //2
    }
    public void reader(){
        if(flag){      //3
            int i = a; //4
        }
    }
}
