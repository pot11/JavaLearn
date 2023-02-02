package binarySortTree.p1;

import org.junit.Test;

public class BinarySortTreeDemoTest {

    //测试遍历
    @Test
    public void test1(){
        BinarySortTree binarySortTree = new BinarySortTree();
        Node root = new Node(1,"松江",null,null);
        Node node2 = new Node(2,"无用",null,null);
        Node node3 = new Node(3,"卢俊",null,null);
        Node node4 = new Node(4,"林冲",null,null);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
//        binarySortTree.setRoot(root);
//        binarySortTree.preOrder(root);//1，2，3，4
//        binarySortTree.infixOrder(root);//2，1，3，4
        binarySortTree.postOrder(root);//2，4，3，1
    }

    //测试遍历查找5号
    @Test
    public void test2(){
        BinarySortTree binarySortTree = new BinarySortTree();
        Node root = new Node(1,"松江",null,null);
        Node node2 = new Node(2,"无用",null,null);
        Node node3 = new Node(3,"卢俊",null,null);
        Node node4 = new Node(4,"林冲",null,null);
        Node node5 = new Node(5,"关胜",null,null);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
//        binarySortTree.setRoot(root);
//        binarySortTree.preOrder(root);//1，2，3，4
//        binarySortTree.infixOrder(root);//2，1，3，4
//        binarySortTree.postOrder(root);//2，4，3，1
//        binarySortTree.preOrderSearch(root);
//        binarySortTree.infixOrderSearch(root);
        binarySortTree.postOrderSearch(root);
    }

    //测试遍历删除5号
    @Test
    public void test3(){
        BinarySortTree binarySortTree = new BinarySortTree();
        Node root = new Node(1,"松江",null,null);
        Node node2 = new Node(2,"无用",null,null);
        Node node3 = new Node(3,"卢俊",null,null);
        Node node4 = new Node(4,"林冲",null,null);
        Node node5 = new Node(5,"关胜",null,null);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binarySortTree.setRoot(root);
//        System.out.println("前序遍历前：");
//        binarySortTree.preOrder(root);//1，2，3，5，4
//        binarySortTree.delNode(root);
//        System.out.println("删除后：");
//        binarySortTree.preOrder(root);//1，2

//        System.out.println("中序遍历前：");
//        binarySortTree.infixOrder(root);//2，1，3，5，4
//        System.out.println("删除后：");
//        binarySortTree.delNode(root);
//        binarySortTree.infixOrder(root);//2，1，3，4

        System.out.println("后序遍历前：");
        binarySortTree.postOrder(root);//2，5，4，3，1
        binarySortTree.delNode(root);
        System.out.println("删除后：");
        binarySortTree.postOrder(root);//2，4，3，1
    }






}
