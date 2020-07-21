package datastructures.skiplist;

import java.util.Random;

public class SkipList {
    private static final int MAX_LEVEL =16;
    private int levelCount = 1;
    private Node head = new Node(MAX_LEVEL);
    private Random r = new Random();

    public Node find(int value){
        Node p = head;
        //从最大层开始查找，找到前一个节点，通过--i 移动到下层再开始查找
        for(int i= levelCount-1;i>=0 ;--i){
            while ( p.forwards[i].data<value){
                    //找到前一个节点
                    p = p.forwards[i];
            }
        }
        if(p.forwards[0]!=null && p.forwards[0].data==value){
            return p.forwards[0];
        }else {
            return  null;
        }
    }


    public class Node{
        private int data = -1;
        /**
         * 表示当前节点位置的下一个节点所有层的数据
         * 从上层切换到下层，就是数组下标-1
         * forwards[3] 表示当前节点在第三层的下一个节点
         */
        private Node forwards[];
        private int maxLevel = 0;

        public Node(int level) {
            forwards = new Node[level];
        }
    }

}
