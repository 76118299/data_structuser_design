package datastructures.queue;

public class DynamicArrayQueue {
    private String [] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capcity) {
        items = new String[capcity];
        n = capcity;
    }

    public boolean enqueue(String item){
         if(tail == n){  //表示队尾没有空间
             if(head == 0){
                 return false;
             }
             // i++ 等效与 a=i i=i+1 ;  ++i 等效于  i = i+1 a = i;
             for(int i = head; i< tail; ++i){
                    //i - head 求差
                    items[i-head] = items[i];
             }
             tail -= head;//数据搬移之后更新head 和tail；
             head = 0;
         }
         items[tail] = item;
         tail++;
         return  true;
    }
    public String dequeue(){
        if(head == tail){
            return  null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
