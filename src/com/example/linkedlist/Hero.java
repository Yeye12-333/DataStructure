package com.example.linkedlist;

/**
 * @author yeye
 * @date 2022/10/7  10:25
 */
public class Hero {

    /**
     * 排名
     */
    public int id;

    /**
     * 英雄名字
     */
    public String username;

    /**
     * 用来指向下一个节点的next域
     */
    public Hero next;

    public Hero(int id, String username){
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", next=" + next +
                '}';
    }
}
