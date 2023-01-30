package binarySortTree.p1;

public class BinarySortTree {
    private Node root;

    public BinarySortTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder(Node node){
        System.out.println(node);//先输出父节点
        if (node.getLeft() != null){//递归向左前序遍历
            preOrder(node.getLeft());
        }
        if (node.getRight() != null){//递归向右前序遍历
            preOrder(node.getRight());
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(Node node){
        if (node.getLeft() != null){//递归向左前序遍历
            infixOrder(node.getLeft());
        }
        System.out.println(node);//输出父节点
        if (node.getRight() != null){//递归向右前序遍历
            infixOrder(node.getRight());
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(Node node){
        if (node.getLeft() != null){//递归向左前序遍历
            postOrder(node.getLeft());
        }
        if (node.getRight() != null){//递归向右前序遍历
            postOrder(node.getRight());
        }
        System.out.println(node);//输出父节点
    }
}
