package com.tinntetuki.datastructure;

/**
 * 数据结构-链表
 *
 * @author tinntetuki
 * @since 2020/7/13
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
