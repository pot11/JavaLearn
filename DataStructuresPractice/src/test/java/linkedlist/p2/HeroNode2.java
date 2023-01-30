package linkedlist.p2;

public class HeroNode2 {
    private int no;//编号
    private String name;//姓名
    private HeroNode2 next;//指向下一个节点
    private HeroNode2 pre;//指向上一个节点

    public HeroNode2(int no, String name, HeroNode2 next) {
        this.no = no;
        this.name = name;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}
