package com.example.linkedlist;

/**
 * @author yeye
 * @date 2022/10/19  10:44
 */
public class Hero2 {

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
    public Hero2 next;

    public Hero2 pre;

    public Hero2(int id, String username){
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
