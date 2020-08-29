package com.tinntetuki.algo;

/**
 * 一句话描述
 *
 * @author tinntetuki
 * @since 2020/7/27
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(1);

        int max_ten = 0;
        ListNode node = null;
        while (l1 != null || l2!= null) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (max_ten != 0) {
                sum += max_ten;
            }

            if (sum > 10) {
                max_ten = 1;
                sum -= 10;
            } else {
                max_ten = 0;
            }


            if (node != null) {
                node.next = new ListNode(sum);
            } else {
                node = new ListNode(sum);
            }
        }



        if (max_ten > 0) {
            node.next = new ListNode(max_ten);
        }

        System.out.println(node);
        //return node;
    }
}
