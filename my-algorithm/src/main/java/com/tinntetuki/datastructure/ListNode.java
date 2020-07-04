package com.tinntetuki.datastructure;

/**
 * @Auther: tinntetuki
 * @Date: 2020/5/20 23:53
 * @Description: 数据结构-链表
 */
public class ListNode {
    ListNode next;
    int val;

    public ListNode() {
        super();
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
