package linkedlist.p1;

import org.junit.Test;
public class SingleLinkedListDemoTest {

    @Test
    public void test1() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", null);
        HeroNode node3 = new HeroNode(3, "吴用", null);
        HeroNode node2 = new HeroNode(2, "卢俊义", null);
        singleLinkedList.add(node1);
        singleLinkedList.add(node3);
        singleLinkedList.add(node2);
        singleLinkedList.list();
    }

    @Test
    public void test2() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", null);
        HeroNode node3 = new HeroNode(3, "吴用", null);
        HeroNode node2 = new HeroNode(2, "卢俊义", null);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.list();
        HeroNode node4 =  new HeroNode(2, "吕布", null);
        singleLinkedList.update(node4);
        singleLinkedList.list();
    }

    @Test
    public void test3() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", null);
        HeroNode node3 = new HeroNode(3, "吴用", null);
        HeroNode node2 = new HeroNode(2, "卢俊义", null);
        HeroNode node4 = new HeroNode(4, "吕布", null);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        System.out.println("删除前");
        singleLinkedList.list();
        singleLinkedList.delete(node4);
        System.out.println("删除后");
        singleLinkedList.list();
    }


    //题一：获取有效节点个数
    @Test
    public void test4() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", null);
        HeroNode node3 = new HeroNode(3, "吴用", null);
        HeroNode node2 = new HeroNode(2, "卢俊义", null);
        HeroNode node4 = new HeroNode(4, "吕布", null);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        System.out.println("有效节点个数:" + singleLinkedList.getLength());
    }

    //题二：获取倒数第x个节点
    @Test
    public void test5() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", null);
        HeroNode node3 = new HeroNode(3, "吴用", null);
        HeroNode node2 = new HeroNode(2, "卢俊义", null);
        HeroNode node4 = new HeroNode(4, "吕布", null);
        HeroNode node5 = new HeroNode(5, "时迁", null);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node5);
        System.out.println("有效节点个数:" + singleLinkedList.getLength());
        System.out.println(singleLinkedList.findLastIndexNode(1));
    }

    //题三：反转链表
    @Test
    public void test6() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", null);
        HeroNode node3 = new HeroNode(3, "吴用", null);
        HeroNode node2 = new HeroNode(2, "卢俊义", null);
        HeroNode node4 = new HeroNode(4, "吕布", null);
        HeroNode node5 = new HeroNode(5, "时迁", null);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node5);
        System.out.println("原链表:");
        singleLinkedList.list();
        System.out.println("反转后链表:");
        singleLinkedList.reversetList();
        singleLinkedList.list();
    }

    //题四：打印反转后列表（不能破解原链表）
    @Test
    public void test7() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", null);
        HeroNode node3 = new HeroNode(3, "吴用", null);
        HeroNode node2 = new HeroNode(2, "卢俊义", null);
        HeroNode node4 = new HeroNode(4, "吕布", null);
        HeroNode node5 = new HeroNode(5, "时迁", null);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node5);
        System.out.println("原链表:");
        singleLinkedList.list();
        System.out.println("打印反转后链表:");
        singleLinkedList.reversePrint();
        singleLinkedList.list();
    }

}
