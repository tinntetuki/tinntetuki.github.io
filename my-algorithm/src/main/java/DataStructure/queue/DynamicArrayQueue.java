package DataStructure.queue;

/**
 * @Auther: tinntetuki
 */
public class DynamicArrayQueue {

    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }


    // 入队操作，将item放入队尾
    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }

            for (int i = head; i< tail; ++i) {
                items[i-head] = items[i];
            }

            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue() {
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
        DynamicArrayQueue queue = new DynamicArrayQueue(3);
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
