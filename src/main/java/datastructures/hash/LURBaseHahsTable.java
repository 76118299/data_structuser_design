package datastructures.hash;

import datastructures.skiplist.SkipList;

import java.util.HashMap;

public class LURBaseHahsTable<K,V> {
    /**
     * 默认链表的容量
     */
    private final static Integer DEFAULT_CAPACIT = 10;
    /**
     * 头节点
     */
    private DNode<K,V> headNode;
    /**
     * 尾节点
     */
    private DNode<K,V> tailNode;
    /**
     * 链表长度
     */
    private Integer length;
    /**
     * 链表容量
     */
    private Integer capacity;
    /**
     * 散列表存储Key
     */
    private HashMap<K,DNode<K,V>> table;

    /**
     * 双向链表
     * @param <K>
     * @param <V>
     */
    private class DNode<K,V>{
        private K key;
        private V value;
        /**
         * 前驱指针
         */
        private DNode<K,V> prev;
        /**
         * 后继指针
         */
        private DNode<K,V> next;

        public DNode() {
        }
        public DNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public LURBaseHahsTable(int capacity){
        this.length = 0;
        this.capacity = capacity;
        headNode = new DNode<K, V>();
        tailNode = new DNode<K, V>();
        headNode.next = tailNode;
        tailNode.prev = headNode;
        table = new HashMap<K, DNode<K, V>>();
    }
    public LURBaseHahsTable(){
        this(DEFAULT_CAPACIT);
    }

    /**
     * 新增节点到头部
     * @param newNode
     */
    private void addNode(DNode<K,V> newNode){
        newNode.next = headNode.next;
        newNode.prev = headNode;
        headNode.next.prev = newNode;
        headNode.next = newNode;
    }

    /**
     * 移除节点
     * @param node
     */
    private void removeNode(DNode<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 弹出尾部节点
     * @return
     */
    private DNode<K,V> popTail(){
        DNode node = tailNode.prev;
        removeNode(node);
        return node;
    }

    /**
     * 将节点移动到头部
     * @param node
     */
    private void moveHead(DNode<K,V> node){
        removeNode(node);
        addNode(node);
    }

    /**
     * 获取一个节点的数据
     * @param key
     * @return
     */
    public V get(K key){
        DNode<K, V> kvdNode = table.get(key);
        moveHead(kvdNode);
        return kvdNode.value;
    }
    private void remove(K key){
        DNode<K, V> kvdNode = table.get(key);
        removeNode(kvdNode);
        length--;
        table.remove(key);
    }
    public void  add(K key,V value){
        DNode<K,V> node = table.get(key);
        if(node == null){
            DNode<K,V> newNode = new DNode<K, V>(key,value);
            table.put(key,newNode);
            addNode(newNode);
            if(++length>capacity){
                length--;
                DNode<K, V> kvdNode = popTail();
                table.remove(kvdNode.key);
            }
        }else {
            node.value =value;
            moveHead(node);
        }
    }
}
