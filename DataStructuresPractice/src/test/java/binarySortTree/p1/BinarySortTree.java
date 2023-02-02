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

    /**
     * 前序遍历查找
     */
    public Node preOrderSearch(Node node){
        Node resNode = null;
        //比较当前节点编号
        System.out.println("进入前序遍历比较");//先比较父节点
        if (node.getNo() == 5){
            resNode = node;
        }
        if (resNode != null){
            return resNode;
        }
        if (node.getLeft() != null){//递归向左前序遍历
            resNode = preOrderSearch(node.getLeft());
        }
        if (resNode != null){
            return resNode;
        }
        if (node.getRight() != null){//递归向右前序遍历
            resNode = preOrderSearch(node.getRight());
        }
        return resNode;
    }

    /**
     * 中序遍历查找
     */
    public Node infixOrderSearch(Node node){
        Node resNode = null;
        if (node.getLeft() != null){//递归向左前序遍历
            resNode = infixOrderSearch(node.getLeft());
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("进入前序遍历比较");//比较父节点
        if (node.getNo() == 5){
            resNode = node;
        }
        if (resNode != null){
            return resNode;
        }
        if (node.getRight() != null){//递归向右前序遍历
            resNode = infixOrderSearch(node.getRight());
        }
        return resNode;
    }

    /**
     * 后序遍历查找
     */
    public Node postOrderSearch(Node node){
        Node resNode = null;
        if (node.getLeft() != null){//递归向左前序遍历
            resNode = postOrderSearch(node.getLeft());
        }
        if (resNode != null){
            return resNode;
        }
        if (node.getRight() != null){//递归向右前序遍历
            resNode = postOrderSearch(node.getRight());
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("进入前序遍历比较");//比较父节点
        if (node.getNo() == 5){
            resNode = node;
        }
        return resNode;
    }

    /**
     * 删除节点
     */
    public Node delNode(Node node){
        Node resNode = null;
        //如果当前结点的左子节点不为空，并且左子节点就是要删除节点，将this.left== null;并且返回（结束递归删除）
        if (node.getLeft() != null && node.getLeft().getNo() == 5){
            node.setLeft(null);
            return node;
        }
        //如果当前结点的右子节点不为空，并且右子节点就是要删除节点，将this.right== null;并且返回（结束递归删除）
        if (node.getRight() != null && node.getRight().getNo() == 5){
            node.setRight(null);
            return node;
        }
        if (node.getLeft() != null){//递归向左子树递归删除
            resNode = delNode(node.getLeft());
        }
        if (node.getRight() != null){//递归向左子树递归删除
            resNode = delNode(node.getRight());
        }
        return resNode;
    }

}
