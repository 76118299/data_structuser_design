package datastructures.linked;

import design.iterator.MyLinkList;
import org.omg.CORBA.NO_IMPLEMENT;

public class SinglyLinkedLit<T> {
    private  class Node<T>{
         T data;
         Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
 private Node<Integer> head = null;
    /**
     * 根据value 返回节点
     */
    public Node findByValue(T value){
        Node p = head;
        while (p!=null&&p.data == value){
            p = p.next;
        }
        return p;
    }
    /**
     * 根据index返回节点
     */
    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while (p!=null && pos!=index){
            ++pos;
           p= p.next;
        }
        return  p;
    }

    /**
     * 表头部插入节点
     * @param value
     */
    public void insetToHead(Integer value){
        Node<Integer> newNode = new Node<Integer>(value);
        insetToHead(newNode);
    }

    /**
     * 从头部插入节点
     * @param newNode
     */
    public void insetToHead(Node newNode){
        if(head == null){
            head = newNode;
        }else {
            /**
             * 插入头节点
             */
            newNode.next = head;
            head  = newNode;
        }
    }

    /**
     * 尾部插入节点
     * @param value
     */
    public void insertTail(int value){
        Node<Integer> newNode = new Node<Integer>(value);
        if(head == null){
            head = newNode;
        }else {
            Node q = head;
            while (q.next!=null){
                q=q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    /**
     *  向节点尾部插入节点
     * @param p
     * @param newNode
     */
    public void insertAfter(Node p,Node newNode){
        if(p == null){
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 向节点尾部插入节点
     * @param p
     * @param value
     */
    public void insertAfter(Node p,Integer value){
        Node newNode = new Node(value);
        insertAfter(p,newNode);
    }

    /**
     * 某个节点的后面插入
     * @param p
     * @param newNode
     */
    public void  inserBefore(Node p ,Node newNode){
        if(p == null){
            return;
        }
        //某个节点的后面插入节点
        newNode.next = p.next;
        p.next=newNode;
    }

    /**
     * 某个节点的前面插入节点
     * @param p
     * @param newNode
     */
    public void insertBefore(Node p ,Node newNode){
        if(p == null){
            return;
        }
        if(head == p){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node q = head;
        while (q!=null && q.next!=p){
            q = q.next;
        }
        if(q == null){
            return;
        }
        //某个节点的前面插入新的节点
        newNode.next = p;
        q.next = newNode;

    }

    /**
     * 删除某个节点
     */
    public void  deleteByNode(Node p){
        if(p == null || head == null){
            return;
        }
        if(p == head){
            head = head.next;
        }
        Node q = head;
        while (q!=null && q.next!=p){
            q=q.next;
        }
        if(q == null){
            return;
        }
        q.next = q.next.next;
    }

    public void  deleteByIndex(Integer value){
        if(head==null){
            return;
        }
        Node p = head;
        Node q = null;
        while (p!=null &&  p.data !=value){
            q = p; //保存上一个节点
            p = p.next;
        }
        if(p == null){
            return;
        }
        if(q == null){
            head = head.next;
        }else {
            q.next = q.next.next;
        }
    }
    public boolean TFResult(Node left,Node right){
        Node l = left;
        Node r =right;
        boolean flag = true;
        while (l!=null && r!=null){
            if(l.data == r.data){
                l = l.next;
                r = r.next;
                continue;
            }else {
                flag = false;
                break;
            }
        }
        return  flag;
    }

    /**
     * 判断是否有回文
     */
    public boolean palindrome(){
        if(head == null){
            return false;
        }else {
            Node p = head;
            Node q = head;
            if(p.next == null){
                return  true;
            }
            /**
             *
             */
            while (q.next!=null && q.next.next!=null){
                p = p.next;//获取链表的上半部分
                q = q.next.next;
            }
            Node leftLink = null;
            Node rightLink = null;
            if(q.next == null){
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
            }else {
                rightLink  = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink,rightLink);
        }

    }
    //无头链表反转
    public Node inverseLinkList(Node p){
        Node pre = null; //上一个节点
        Node r = head;//头节点
        Node next = null;//下一个节点
        while (r !=p){
            next = r.next;//r的下一个节点给next
            r.next = pre; //r的下一个节点赋值 pre
            pre = r;      //pre赋值r
            r = next;   //r 的下一个节点给r
        }
        r.next = pre;
        return  r;
    }
    //带头节点反转
    public Node inverseLinkList_head(Node p){
        Node Head = new Node(9999);
        Head.next = p;
        Node Cur = p.next;
        p.next = null;
        Node next = null;
        while (Cur!=null){
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            Cur = next;
        }
        return  Head;
    }


}

