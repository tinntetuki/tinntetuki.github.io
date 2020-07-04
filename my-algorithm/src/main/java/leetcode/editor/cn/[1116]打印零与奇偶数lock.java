package leetcode.editor.cn;//假设有这么一个类：
//
// class ZeroEvenOdd {
//  public ZeroEvenOdd(int n) { ... }      // 构造函数
//  public void zero(printNumber) { ... }  // 仅打印出 0
//  public void even(printNumber) { ... }  // 仅打印出 偶数
//  public void odd(printNumber) { ... }   // 仅打印出 奇数
//}
// 
//
// 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程： 
//
// 
// 线程 A 将调用 zero()，它只输出 0 。 
// 线程 B 将调用 even()，它只输出偶数。 
// 线程 C 将调用 odd()，它只输出奇数。 
// 
//
// 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n
//。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出："0102"
//说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出："0102030405"
// 
//


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

//leetcode submit region begin(Prohibit modification and deletion)
class ZeroEvenOddLock {
    /*private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    private volatile int start = 1;
    private volatile int who;


    private int n;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n){
                if (who != 0) {
                    zero.await();
                }

                printNumber.accept(0);
                if (start %2 == 0) {
                    who =2;
                    even.signal();
                } else {
                    who = 1;
                    odd.signal();
                }

                zero.await();
            }

            odd.signal();
            even.signal();
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (who != 2) {
                    even.await();
                } else {
                    printNumber.accept(start ++);
                    who = 0;
                    zero.signal();
                }
            }

        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n){
                if (who != 1) {
                    odd.await();
                } else {
                    printNumber.accept(start++);
                    who = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)
