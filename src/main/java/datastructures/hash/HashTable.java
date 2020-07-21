package datastructures.hash;

import java.util.HashMap;

public class HashTable<K,V> {
    /**
     *散列得默认长度
     */
    private static final int DEFAULT_INITAL_CAPACITY = 8;

    /**
     *装载因子
     */
    private static final float LOAD_FACTOR = 0.75f;

    /**
     *初始化散列数组
     */
    private Entry[] table;

    /**
     *实际元素数量
     */
    private int size = 0;

    /**
     *散列表索引数量
     */
    private int use = 0;

    public HashTable(){
        table = (Entry<K,V>[]) new Entry[DEFAULT_INITAL_CAPACITY];
    }

    /**
     * 新增
     * @param key
     * @param value
     */
    public void put(K key,V value){
        //使用hash函数获取hash值
        int index = hash(key);
        //位置未被引用，创建哨兵节点 也就是说创建链表头
        if(table[index] == null){
            table[index] = new Entry(null,null,null);
        }
        Entry<K,V> tmp = table[index];
        //新增节点
        if(tmp.next == null){
            tmp.next = new Entry<K, V>(key,value,null);
            size++;//元素数量加加
            use++; //散列表索引数量
            //动态扩容 散列表的装载因子=填入表中的元素个数/散列表的长度
            if(use >= table.length * LOAD_FACTOR ){
                resize();
            }
        }else { //解决散列冲突 使用链表法
            do{
                //取出冲突得节点
                tmp = tmp.next;
                //找到相同key 则覆盖旧得数据
                if(tmp.key == key){
                    tmp.value = value;
                }
            }while (tmp.next!=null); //这里是一直遍历到队尾
            //获取头节点得下一个节点
            Entry<K,V> temp = table[index].next;
            //这里需要再创建一个新得节点
            table[index].next = new Entry(key,value,temp);//这里就是覆盖冲突节点得value
            size++;
        }

    }

    /**
     * 动态扩容
     * 就是创建一个新得table 长度是原来得2倍
     * 再重新赋值一次
     */
    private void resize() {
        Entry<K,V>[] oldTable = table;
        //创建新得hanshTable并且长度是原来得2倍
        table = new Entry[table.length * 2];
        use = 0;
        //外层遍历数组
        for(int i = 0;i<oldTable.length;i++){
            if(oldTable[i] == null || oldTable[i].next == null){
                continue;
            }
            //获取旧得 hanshTable中每个链表得头节点
            Entry<K,V> e = oldTable[i];
            //内层再遍历链表
            while (e.next!=null){
                 e = e.next;
                 int index = hash(e.key);//
                 if(table[index] == null){
                     use++;
                     //创建哨兵节点 即头节点 并添加到新得hashtable中
                     table[index] = new Entry(null,null,null);
                 }
                 //向链表得尾部添加节点
                 table[index].next = new Entry(e.key,e.value,table[index].next);
            }
        }
    }

    private int hash(Object key){
        int h = 0;
        return (key == null )? 0 : (h = key.hashCode() ^ (h >>> 16)) % table.length;
    }

    public void remove(K key){
        //依然是获取hansh值
        int index = hash(key);
        Entry e = table[index]; //获取药删除得节点
        if(e == null || e.next == null){
            return;
        }
        //这里得删除应该是 目标节点得 前驱节点得 pre.next = e.next;

        Entry pre;
        Entry<K,V> headNode = table[index];//获取头节点
        //这里是删除hansh冲突得节点
        do{
            pre = e; //前驱节点
            e = e.next; //要删除得节点
            if(key == e.key){ //这里是找到要删除得节点
                pre.next = e.next;//删除节点操作
                size--; //元素个数
                if(headNode.next == null){
                    use--; //索引数量
                }
                return;
            }
        }while (e.next !=null);
    }

    public V get(K key){
        int index = hash(key);
        Entry entry = table[index];
        if(entry == null || entry.next == null){
            return null;
        }
        while (entry.next!=null){
            entry = entry.next;
            if(entry.key == key){
                return (V) entry.value;
            }
        }
        return null;
    }



    private class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
