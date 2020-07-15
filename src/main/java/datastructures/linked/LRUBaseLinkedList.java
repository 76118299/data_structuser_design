package datastructures.linked;

public class LRUBaseLinkedList<T> {
    /**
     * 默认容量
     */
    private final static Integer DEFATU_CAPACITY=10;
    /**
     * 头节点
     */
    private SNode<T> headNode;
    /**
     * 链表长度
     */
    private Integer length;
    /**
     * 链表容量
     */
    private Integer capacity;
    public LRUBaseLinkedList(){
        this.headNode = new SNode<T>();
        this.capacity = DEFATU_CAPACITY;
        this.length = 0;
    }
    public LRUBaseLinkedList(Integer capacity){
        this.headNode = new SNode<T>();
        this.capacity =capacity;
        this.length = 0;
    }

    public void add(T data){
        //查找前一个节点
        SNode preNode = findPreNode(data);
        //链表中存在，删除原数据，再插入到链表的头部
        if(preNode !=null){
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        }else {
            //如果链表满了 则删除尾节点 插入到头节点
            if(length>=this.capacity){
                deleteElemAtEnd();
            }
            //未满的情况下直接插入头部
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode节点的下一个元素
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode){
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 头部插入节点
     * @param data
     */
    private void insertElemAtBegin(T data){
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
    }

    /**
     * 查找元素的前一个节点
     * @param data
     * @return
     */
    private SNode findPreNode(T data){
        SNode node = headNode;
        while (node.getNext()!=null){
            if(data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return  null;
    }

    /**
     * 删除尾节点
     */
    private void deleteElemAtEnd(){
        SNode ptr =headNode;
        if(ptr.getNext() == null){
            return;
        }
        while (ptr.getNext().getNext()!=null){
            ptr = ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length --;
    }

    public class SNode<T>{
        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }

        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }
        public SNode(){
            this.next = null;
        }
    }
}
