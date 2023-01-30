package linkedlist.p2;

import linkedlist.p1.HeroNode;
import linkedlist.p1.SingleLinkedList;
import org.junit.Test;

public class DoubleLinkedListDemoTest {

    @Test
    public void test1() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 node1 = new HeroNode2(1, "宋江", null);
        HeroNode2 node3 = new HeroNode2(3, "吴用", null);
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", null);
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node2);
        doubleLinkedList.list();
    }

    @Test
    public void test2() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 node1 = new HeroNode2(1, "宋江", null);
        HeroNode2 node3 = new HeroNode2(3, "吴用", null);
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", null);
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);
        doubleLinkedList.list();
//        HeroNode2 node4 =  new HeroNode2(2, "吕布", null);
//        doubleLinkedList.update(node4);
//        doubleLinkedList.list();
    }

    @Test
    public void test3() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 node1 = new HeroNode2(1, "宋江", null);
        HeroNode2 node3 = new HeroNode2(3, "吴用", null);
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", null);
        HeroNode2 node4 = new HeroNode2(4, "吕布", null);
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);
        System.out.println("删除前");
        doubleLinkedList.list();
        doubleLinkedList.delete(node3);
        System.out.println("删除后");
        doubleLinkedList.list();
    }


}
