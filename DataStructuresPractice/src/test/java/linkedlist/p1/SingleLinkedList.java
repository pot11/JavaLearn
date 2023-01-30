package linkedlist.p1;

import java.util.Stack;

/**
 * 单链表实现
 */
public class SingleLinkedList {
    //注：temp始终指向其中一个节点

    //头节点
    HeroNode head = new HeroNode(0,"", null);

    //添加
    public void add(HeroNode heroNode){
        //头节点 定义临时变量temp指向头节点
        //判断节点中next== null,证明是最后一个节点，
        // 是，可以追加，设置temp中next节点==要追加的数据；
        // 否，将temp变量指向下一个节点
        HeroNode temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    //添加(按照no顺序升序)
    public void addByOrder(HeroNode heroNode){
        //1.头节点 定义临时变量temp指向头节点
        //判断节点中next== null,证明是最后一个节点，
        //2.找到要插入的位置
            //temp.next.getNo() == heroNode.getNo() 已存在
            //temp.next.getNo() > heroNode.getNo() 插在temp变量后面（temp下一个变量前面）
        //3.设置位置 heroNode.next = temp.next   temp.next = heroNode
        HeroNode temp = head;
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
            temp.setNext(heroNode);
        }

    }

    //修改
    public void update(HeroNode heroNode){
        //1.找到节点
        //2.修改内容
        HeroNode temp = head;
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
    public void delete(HeroNode heroNode){
        //1.temp指向 要删除节点的前一个节点位置  no判断
        //2.设置节点 temp.setNext(temp.getNext().getNext())
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() == heroNode.getNo()){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.setNext(temp.getNext().getNext());
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
        HeroNode temp = head.getNext();
        if (temp == null){
            System.out.println("链表为空");
        }
        while (temp.getNext() != null){
            System.out.println(temp.getName());
            temp = temp.getNext();
        }
        System.out.println(temp.getName());
    }


    //获取有效节点个数
    public int getLength() {
        //头节点 定义临时变量temp指向头节点
        //判断节点中next== null,证明是最后一个节点，
        //去除头节点
        HeroNode temp = head.getNext();
        int length = 0;
        if (temp == null){
            System.out.println("链表为空");
        }
        while (temp != null){
            length ++;
            temp = temp.getNext();
        }
        return length;
    }

    //获取有效节点个数
    public HeroNode findLastIndexNode(int index) {
        //头节点 定义临时变量temp指向头节点
        //判断节点中next== null,证明是最后一个节点，
        //去除头节点
        //遍历一遍链表长度length
        //遍历到第length-index个节点
        int size = getLength();
        if (size == 0){
            System.out.println("链表为空");
            return null;
        }
        if (index <=0 || index > size){
            System.out.println("输入错误");
            return null;
        }
        HeroNode temp = head.getNext();
        for (int i = 0; i < size - index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    //反转单链表
    public HeroNode reversetList() {
        if (head.getNext() == null || head.getNext().getNext() == null){
            System.out.println("链表为空或只有一个节点，无需反转");
            return head;
        }
        HeroNode cur = head.getNext();
        HeroNode reversHead = new HeroNode(0, null, null);
        HeroNode next = null;
        while (cur != null){
            next = cur.getNext();//当前节点的下一个节点，保存下来后面遍历要用
            cur.setNext(reversHead.getNext());//将反转后的新链表中头节点的下一个节点，指向原当前节点的下一个节点（将原链表当前节点插入新链表头节点之后）
            reversHead.setNext(cur);//新链表头节点下一个节点指向原链表当前节点
            cur = next;//遍历原链表
        }
        head = reversHead;
        return head;
    }


    //打印反转单链表
    public void reversePrint() {
        if (head.getNext() == null || head.getNext().getNext() == null){
            System.out.println("链表为空或只有一个节点，无需反转");
        }
        HeroNode cur = head.getNext();
        HeroNode reversHead = new HeroNode(0, null, null);
        HeroNode next = null;
        Stack<HeroNode> stack = new Stack<>();
        while (cur != null){
            stack.push(cur);
            cur = cur.getNext();//遍历原链表
        }
        while (stack.size() >0){
            System.out.println(stack.pop());
        }
    }
}
