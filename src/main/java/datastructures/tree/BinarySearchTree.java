package datastructures.tree;

public class BinarySearchTree {
    private Node tree;
    /**
     * 前序遍历
     */
    void preOrder(Node root){
        if(root == null){
            return;
        }
       //打印节点
        System.out.println("root = " + root);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println("root = " + root);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    void  postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println("root = " + root);
    }

    public Node find(int data){
        Node p = tree;
        while (p!=null){
            if(data<p.data){
                p = p.left;
            }else if(data>p.data){
                p=p.right;
            }
            return p;
        }
        return null;
    }


    public void insert(int data){
        if(tree == null){
            tree = new Node(data);
        }
        Node p = tree;
        while (p!=null){
            if(data<p.data){
                if(p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }else {
                if(data>p.data){
                    if(p.right == null){
                        p.right = new Node(data);
                        return;
                    }
                    p = p.right;
                }
            }
        }
    }
    public Node findMin(){
        if(tree == null){
            return null;
        }
        Node p = tree;
        while (p.left != null){
            p = p.left;
        }
        return p;
    }
    public Node findMax(){
        if(tree == null){
            return  null;
        }
        Node p = tree;
        while (p.right != null){
            p = p.right;
        }
        return p;
    }
    public void delete(int data){
        Node p = tree; // p 指向要删除得节点。初始化指向根节点
        Node pp = null; //pp 记录得是p得父节点
        while (p!=null && p.data!=data){
            pp = p;
            if(data>p.data){
                p = p.right;
            }else {
                p = p.left;
            }
        }
        if(p == null){
            return; //没找到
        }
        //要删除得节点有2两个子节点
        if(p.left!= null && p.right!=null){ //查找右子树最小得节点
            Node minp = p.right;
            Node minpp = p;
            while (minp.left!=null){
                minp = minpp.left;
                minpp = p;
            }

            p.data = minp.data;//将minp得数据替换到p中
            p = minp;//删除minp
            pp = minpp;
        }
        //删除得节点是叶子节点或者仅有一个子节点
        Node child;
        if(p.left!=null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }else {
            child = null;
        }
        if(pp == null){
            tree = child;
        }else if(pp.left == p){
            pp.left = child;
        }else {
            pp.right = child;
        }

    }
    public class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
