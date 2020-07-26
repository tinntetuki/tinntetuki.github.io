package com.tinntetuki.datastructure;

/**
 * 最大堆
 *
 * @author tinntetuki
 * @since 2020/7/18
 */
public class MaxPQ <Key extends Comparable<Key>>{

    /**
     * 存储元素的数组
     */
    private Key[] pq;
    /**
     * 当前数组中元素的个数
     */
    private int n = 0;

    public MaxPQ (int cap) {
        //索引0不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }

    /**
     * 返回当前最大的元素
     * @return
     */
    public Key max(){
        return pq[1];
    }

    /**
     * 插入元素
     * @param k
     */
    public void insert(Key k){
        n++;
        pq[n] = k;
        swim(n);
    }

    /**
     * 删除并返回队列中最大的元素
     * @return
     */
    public Key delMax(){
        //堆顶元素
        Key max = pq[1];
        //交换到最后，删除
        exch(1, n);
        pq[n] = null;
        n--;
        //下沉到最后位置
        sink(1);
        return max;
    }

    /**
     * 上浮第k个元素，以维护最大堆性质
     * @param k
     */
    private void swim(int k){
        while (k > 1 && less(parent(k), k)){
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 下沉第k个元素，以维护最大堆性质
     * @param k
     */
    private void sink(int k){
        while (left(k) <= n){
            int older = left(k);

            if (right(k) <= n && less(older, right(k))) {
                older = right(k);
            }

            if (less(older, k)) {
                break;
            }

            exch(k, older);
            k = older;
        }
    }

    private int right(int k) {
        return k+1;
    }

    private int left(int k) {
        return k-1;
    }

    /**
     * 交换数组中的两个元素
     * @param i
     * @param j
     */
    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * pq[i]是否比pq[j]小
     * @param i
     * @param j
     * @return
     */
    public boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    public int parent(int k){
        return k/2;
    }
}
