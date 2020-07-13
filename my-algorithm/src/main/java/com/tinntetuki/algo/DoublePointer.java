package com.tinntetuki.algo;

import com.tinntetuki.datastructure.ListNode;

import java.util.Arrays;

/**
 * 算法-双指针
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class DoublePointer {

    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
    static boolean hasCycle (ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断环的其实位置
     * @return
     */
    static ListNode detectNode(ListNode head){
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (slow == fast) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
    }

    /**
     * 寻找链表的中间节点
     * @param head
     * @return
     */
    static ListNode middleNode(ListNode head){
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    /**
     * 链表的第k个节点
     * @param head
     * @param k
     * @return
     */
    static ListNode kNode(ListNode head, int k){
        ListNode slow, fast;
        slow = fast = head;

        while ( k > 0 ){
            fast = fast.getNext();
            k--;
        }

        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
    }

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    static int[] twoSum(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target){
                left ++;
            } else if (sum > target) {
                right --;
            }
        }
        return new int []{-1, -1};
    }

    /**
     * 数组反转
     * @param nums
     * @return
     */
    static int[] reverse(int[] nums) {
        int left = 0, right = nums.length -1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
        return nums;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(reverse(new int[]{1,2,3,4,5})));
    }
}
