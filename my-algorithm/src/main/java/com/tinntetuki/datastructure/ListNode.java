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

    public ListNode(int val) {
        this.val = val;
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

    ListNode reverse(ListNode head){
        if (head.next == null) {
            return head;
        }

        ListNode last = reverse(head);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
