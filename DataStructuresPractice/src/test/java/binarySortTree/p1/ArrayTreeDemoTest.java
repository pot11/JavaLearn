package binarySortTree.p1;

import org.junit.Test;

public class ArrayTreeDemoTest {

    //测试遍历
    @Test
    public void test1(){
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree();
        int[] arr = {1,2,3,4,5,6,7};
        arrayBinaryTree.setArr(arr);
//        arrayBinaryTree.preOrder(0);//1,2,4,5,3,6,7
//        arrayBinaryTree.infixOrder(0);//4,2,5,1,6,3,7
        arrayBinaryTree.postOrder(0);//4,5,2,6,7,3,1
    }

}
