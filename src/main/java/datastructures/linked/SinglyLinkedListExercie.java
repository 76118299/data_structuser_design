package datastructures.linked;

public class SinglyLinkedListExercie {
    private class Node{
        int data;
        public Node next;

        public Node(int value, Node next) {
            this.data = value;
            this.next = next;
        }
    }
    private Node head = null;
    public Node findByValue(int data){
        Node p = head;
        while (p!=null && p.data!=data){
            p = p.next;
        }
        return p;
    }
    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while (p!=null && pos !=index){
            p = p.next;
            pos++;
        }
        return  p;
    }
    /**
     * 向头节点插入
     */
    public  void  insetToHead(Node newNode){
        if(head == null){
            head = newNode;
        }else {
            //head 的指针赋值next
            newNode.next = head;
            //新节点的内存地址赋值给head
            head = newNode; //newNOde就变成头了
        }
    }
    // 像尾部插入节点
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        if(head == null){
            head = newNode;
        }else {
            Node p = head;
            while (p.next != null){
                p = p.next;
            }
            //如果是中间的节点必须有这句代码
            newNode.next = p.next; //这个是从头开始的
            p.next = newNode;


        }
    }
    //某个节点之后插入新节点
    public void  insertAfter(Node p,Node newNode){
        if(p == null){
            return;
        }
        newNode.next = p.next;
        //如果先执行这句 p.next 丢了
        p.next = newNode;
    }
    //某个节点之前
    public void  insertBefore(Node p,Node newNode){
        if(p == null){
            return;
        }
        if(head == p){
            insetToHead(newNode);
            return;
        }
        Node q = head;
        while (q!= null&&q.next!=p){
            q =q.next;
        }
        if(q == null){
            return;
        }
       newNode.next  = p;
        q.next = newNode;
    }

    public void deleteByNode(int value){
        Node q = head;
        Node p = null;
        while (q!=null&&q.data!=value){
            p = q;
            q = q.next;
        }
        if(q==null){
            return;
        }
        if(p == null){
            head = head.next;
        }else {
            q.next = q.next.next;
        }
    }
    //带节点的链表反转
    public Node inverseLikList_head(Node p){
        Node head = new Node(9999,null);
        head.next  = p;
        /**
         * 带头节点的链表等价于
         * 从第二个元素开始重新头插法建立链表
         */
        Node Cur = p.next;
        p.next = null;
        Node next = null;
        while (Cur!=null){

            next = Cur.next;
            //p的下一个节点 是p
            Cur.next = head.next;
            //此时的Cur还是P的next
            head.next = Cur;
            //cur 就是p的下一个节点
            Cur = next;
        }
        return  head;
    }
    public Node inverseLinkList(Node p){
        Node next = null;
        Node pre = null;
        Node r = head;
        while (r != p){
           next =   r.next;
           r.next = pre;
           pre = r;
           r = next;

        }
        return  r;
    }
}
