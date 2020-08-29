package com.tinntetuki.algo;

import com.tinntetuki.datastructure.ListNode;

/**
 * 一句话描述
 *
 * @author tinntetuki
 * @since 2020/7/26
 */
public class ReserveListNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(new ListNode(2));


        ListNode node = null;

        while (listNode != null) {
            ListNode cur = listNode;
            cur.setNext(node);
            node = cur;
            listNode = listNode.getNext();
        }

        System.out.println(node);

    }
}
