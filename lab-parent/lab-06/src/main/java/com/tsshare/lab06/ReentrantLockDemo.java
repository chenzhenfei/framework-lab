package com.tsshare.lab06;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenzhenfei
 * @title: ReentrantLock
 * @projectName framework-lab
 * @description: Lock
 * @date 2020/9/1523:41
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        testReentrantLock();
        testReentrantRwLock();
    }

    private static void testReentrantRwLock() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        writeLock.unlock();


    }

    private static void testReentrantLock() {
        ReentrantLock reentrantLock =new ReentrantLock();
        reentrantLock.lock();
        try{
            // todo 同步代码块
        }catch (Exception e){e.printStackTrace();}finally {
            reentrantLock.unlock();
        }
    }
}
