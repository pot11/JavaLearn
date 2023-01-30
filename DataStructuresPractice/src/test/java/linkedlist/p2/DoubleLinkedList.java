package linkedlist.p2;

import linkedlist.p1.HeroNode;

/**
 * 单链表实现
 */
public class DoubleLinkedList {
    //注：temp始终指向其中一个节点

    //头节点
    HeroNode2 head = new HeroNode2(0,"", null);

    //添加
    public void add(HeroNode2 heroNode){
        //头节点 定义临时变量temp指向头节点
        //判断节点中next== null,证明是最后一个节点，
        // 是，可以追加，设置temp中next节点==要追加的数据；
        // 否，将temp变量指向下一个节点
        HeroNode2 temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }

    //添加(按照no顺序升序)
    public void addByOrder(HeroNode2 heroNode){
        //1.头节点 定义临时变量temp指向头节点
        //判断节点中next== null,证明是最后一个节点，
        //2.找到要插入的位置
            //temp.next.getNo() == heroNode.getNo() 已存在
            //temp.next.getNo() > heroNode.getNo() 插在temp变量后面（temp下一个变量前面）
        //3.设置位置 heroNode.next = temp.next   temp.next = heroNode
        HeroNode2 temp = head;
        Boolean flag = false;
        while (true){
            //先判断是否是最后一个节点，由结果-》推导
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() == heroNode.getNo()){
                flag = true;
                break;
            }else if (temp.getNext().getNo() > heroNode.getNo()){
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            System.out.println("已存在相同编号的英雄，无法插入");
        }else {
            //重点：若只有头节点，亦可进入此方法，直接追加，flag用来判断，while循环只是用来找节点位置
            heroNode.setNext(temp.getNext());
            heroNode.setPre(temp);
            if (temp.getNext() != null){
                temp.getNext().setPre(heroNode);
            }
            temp.setNext(heroNode);
        }

    }

    //修改
    public void update(HeroNode2 heroNode){
        //1.找到节点
        //2.修改内容
        HeroNode2 temp = head;
        Boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() == heroNode.getNo()){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.setName(heroNode.getName());
        }else {
            System.out.println("未找到编号==" + temp.getNo() + "节点");
        }
    }

    //删除
    public void delete(HeroNode2 heroNode){
        //1.temp指向 要删除节点的前一个节点位置  no判断
        //2.设置节点 temp.setNext(temp.getNext().getNext())
        HeroNode2 temp = head.getNext();
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() == heroNode.getNo()){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.getPre().setNext(temp.getNext());
            if (temp.getNext() != null){
                temp.getNext().setPre(temp.getPre());
            }
        }else {
            System.out.println("未找到编号==" + heroNode.getNo() + "的英雄");
        }
    }

    //遍历
    public void list() {
        //头节点 定义临时变量temp指向头节点
        //判断节点中next== null,证明是最后一个节点，
        // 是，可以追加，设置temp中next节点==要追加的数据；
        // 否，将temp变量指向下一个节点
        HeroNode2 temp = head.getNext();
        if (temp == null){
            System.out.println("链表为空");
        }
        while (temp.getNext() != null){
            System.out.println(temp.getName());
            temp = temp.getNext();
        }
        System.out.println(temp.getName());
    }
}
