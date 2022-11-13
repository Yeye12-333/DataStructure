package com.example.linkedlist;

/**
 * @author yeye
 * @date 2022/10/7  10:25
 */
public class SingleLinkedList {
    /**
     * 先创建一个head头节点，这个头节点不能进行操作
     */
   private Hero head = new Hero(0,"");

    public Hero getHead() {
        return head;
    }

    /**
     * 在链表中添加数据
     * @param hero 对象
     */
    public void add(Hero hero){
        //定义一个临时变量temp，将head赋值给temp
        Hero temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = hero;
    }

    //1,3,4,2
    public void sortAdd(Hero hero){
        //定义一个临时变量temp，将head赋值给temp
        Hero temp = head;

        while (true) {
            if(temp.next == null){
                break;
            }
            if(temp.next.id > hero.id){
                hero.next = temp.next;
                temp.next = hero;
                break;
            }else if((temp.id == hero.id)){
                System.out.println("重复了欧，不能添加");
                return;
            }
            temp = temp.next;

        }
        temp.next = hero;
    }

//    1234 3
    public void addOrder(Hero hero){
        Hero temp = head;
        while (temp.next != null){
            if(temp.next.id >= hero.id){
                break;
            }
            temp = temp.next;
        }
        hero.next = temp.next;
        temp.next = hero;
    }

    public void update(Hero newHero){
        Hero temp = head;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.id == newHero.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.username = newHero.username;
        }else {
            System.out.printf("编号为%d的英雄没有找到，不能添加\n", newHero.id);
        }
    }

    public void delete(Hero hero){
        Hero temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }

            if(temp.next.id == hero.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("编号为%d 的节点不存在\n", hero.id);
        }

    }

    public Hero deleteBy(Hero hero, int id){
        if(hero == null){
            return null;
        }
        Hero temp = head;
        while (temp.next != null){
            if(temp.next.id == id){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * 显示链表中的数据
     */
    public void show(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        Hero temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}
