package com.tssahre.stack;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: 栈
 * @date : 2020-06-16 9:06
 */
public interface Stack<T> {
    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * data元素入栈
     * @param data
     */
    void push(T data) throws StackException;

    /**
     * 返回栈顶元素,未出栈  = 获取栈顶元素的值,不删除
     * @return
     */
    T peek();

    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return
     */
    T pop();
}
