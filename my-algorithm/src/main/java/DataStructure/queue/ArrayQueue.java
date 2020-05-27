package DataStructure.queue;

/**
 * 用数组实现的队列
 *
 * @Auther: tinntetuki
 */
public class ArrayQueue {
    /**
     * 数组items
     */
    private String[] items;
    /**
     * 数组大小
     */
    private int n;
    /**
     * 队头下标
     */
    private int head;
    /**
     * 队尾下标
     */
    private int tail;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        if (tail == n) {
            return false;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     * @param
     * @return
     */
    public String dequeue(){
        if (head == tail) {
            return null;
        }

        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.printAll();
        queue.dequeue();
        queue.printAll();
        queue.dequeue();
        queue.printAll();
        queue.enqueue("3");
        queue.printAll();
        queue.enqueue("3");
        queue.printAll();
    }
}
