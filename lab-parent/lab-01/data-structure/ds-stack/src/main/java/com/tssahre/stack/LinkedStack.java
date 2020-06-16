package com.tssahre.stack;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: 链式栈 = 单链表存储 通过节点
 * @date : 2020-06-16 10:08
 */
public class LinkedStack<T> implements Stack<T>, Serializable {

    public static final long serialVersionUID = 2L;

    private Node<T> top;

    public LinkedStack(Node<T> top) {
        this.top = top;
    }

    public LinkedStack() {
    }

    private int size;

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null || top.data == null;
    }

    @Override
    public void push(T data) {
        if (data == null) {
            throw new StackException("data can\'t be null");
        }
        if (this.top == null) {
            this.top = new Node<T>(data, null);
        } else if (this.top.data == null) {
            this.top.data = data;
        } else {
            //添加元素,指针指向新则栈顶
            Node<T> p = new Node<>(data, this.top);
            top = p;
        }
        size++;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.top.data;
    }

    @Override
    public T pop() {
        // 取数据，然后移动指定指向
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        this.top = this.top.next;
        size--;
        return data;
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
