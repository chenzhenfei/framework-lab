package com.tssahre.stack;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: 顺序栈  = 数组存储
 * @date : 2020-06-16 9:01
 */
public class SeqStack<T> implements Stack<T>, Serializable {

    public static final long serialVersionUID = 1L;
    /**
     * 栈顶指针,-1代表空栈
     */
    private int top = -1;
    /***
     * @Description:存储数组
     * @Author: zfchen
     * @Date: 2020/6/16 9:10
     **/
    private T[] array;
    /***
     * @Description: /数组大小
     * @Author: zfchen
     * @Date: 2020/6/16 9:10
     **/
    private int size;
    /***
     * @Description:容量
     * @Author: zfchen
     * @Date: 2020/6/16 9:11
     **/
    private int capacity = 10;

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(T data) {
        if (array.length == size) {
            resize();
        }
        //从栈顶添加元素
        array[++top] = data;
        size++;
    }

    private void resize() {
        //如果需要拓展的容量比现在数组的容量还小,则无需扩容
        if ((size*2+1) < size) {
            return;
        }
        T[] old = array;
        array = (T[]) new Object[capacity];
        //复制元素
        for (int i = 0; i < size; i++) {
            array[i] = old[i];
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        return array[top];
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        size--;
        return array[top--];
    }

    public SeqStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public SeqStack() {
        array = (T[]) new Object[this.capacity];
    }
}
