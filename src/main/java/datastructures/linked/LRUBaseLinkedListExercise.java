package datastructures.linked;

public class LRUBaseLinkedListExercise {
    private final static  Integer DEFAULT_CAPACITY = 10;

    /**
     * 头节点
     */
    private SNode headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表得容量
     */
    private Integer capacity;

    public LRUBaseLinkedListExercise() {
        this.headNode = new SNode();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedListExercise(Integer capacity) {
       this.headNode = new SNode();
       this.capacity = capacity;
       this.length = 0;
    }

    public void add(int data){
        SNode preNode = findPreNode(data);//获得当前节点的前一个节点
        if(preNode!=null){ //如果当前节点存在
            deleteElemOptim(preNode);//删除当前节点
            insertElementAtBegin(data);//当前节点插入头部
        }else {
            if(length >= capacity){
                deleteElementEnd();//删除尾节点
            }
            insertElementAtBegin(data);//当前节点插入头部
        }
    }

    /**
     * 删除preNode节点的下一个节点
     */
    private void deleteElemOptim(SNode preNode){
        SNode temp = preNode.next;
        //把当前节点的下个节点的下一个节点赋值
        preNode.setNext(temp.next);
        temp = null;
        length ++;
    }
    /**
     * 链表头部插入节点
     */
    private void  insertElementAtBegin(int data){
        SNode next = headNode.next;
        //创建一个新节点，新节点的下一个节点就是原来头节点的下一个节点
        headNode.setNext(new SNode(data,next));
        length ++;
    }

    /**
     * 获取查找元素的前一个节点
     */
    private SNode findPreNode(int data){
            SNode node = headNode;
            while (node.next !=null){
                if(node.element  == data){
                    return node;
                }
                node = node.next;
            }
            return null;
    }

    /**
     * 删除尾节点
     */
    private void deleteElementEnd(){
        //先找到头节点
        SNode ptr = headNode;
        if(ptr.next == null){
            return;
        }
        while (ptr.next.next!=null){
            ptr = ptr.next;
        }
        SNode tmp = ptr.next;
        ptr.next = null;
        tmp = null;
        length --;
    }

    public class SNode{
        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        private int element;

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }

        private SNode next;

        public SNode(int element) {
            this.element = element;
        }

        public SNode(int element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

    }
}
