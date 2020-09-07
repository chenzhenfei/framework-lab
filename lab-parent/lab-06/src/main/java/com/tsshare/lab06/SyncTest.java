package com.tsshare.lab06;

/**
 * @author chenzhenfei
 * @title: SyncTest
 * @projectName framework-lab
 * @description: java 对象头
 * @date 2020/9/723:19
 */
public class SyncTest {
    static  User user = new User();
    static  User []users = new User[10];
    public static void main(String[] args) {

    }

    static class User {
        private String name;
        private int id;

        public User() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public User(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}
