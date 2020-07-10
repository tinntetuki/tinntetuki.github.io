package com.tinntetuki.algo;

import leetcode.editor.cn.TreeNode;

/**
 * @Desc 递归
 * @author tinntetuki
 * @date 2020/7/8
 */
public class Recursive {
    /**
     * 归并排序
     * @param a
     * @param lo
     * @param hi
     */
    public void sort(Comparable[] a, int lo, int hi){
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        //merge(a, lo, mid, hi);
    }

    /* 典型的递推遍历框架，需要额外空间 O(1) */
    public int size(Node head) {
        int size = 0;
        for (Node p = head; p != null; p = p.next) size++;
        return size;
    }
    /* 我偏要递归，万物皆递归，需要额外空间 O(N) */
    public int size_1(Node head) {
        if (head == null) return 0;
        return size(head.next) + 1;
    }

    /**
     * 以下详解 LeetCode 的一道题来说明：给一课二叉树，和一个目标值，节点上的值有正有负，
     * 返回树中和等于目标值的路径条数，让你编写 pathSum 函数：
     * 看不懂没关系，底下有更详细的分析版本，这里突出体现递归的简洁优美
     * @param root
     * @param sum
     * @return
     */
    int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return count(root, sum) +
                pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    int count(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum) ? 1 : 0 +
                count(node.left, sum - node.val) +
                count(node.right, sum - node.val);
    }

    /* 有了以上铺垫，详细注释一下代码 */
    int pathSum_1(TreeNode root, int sum) {
        if (root == null) return 0;
        int pathImLeading = count(root, sum); // 自己为开头的路径数
        int leftPathSum = pathSum_1(root.left, sum); // 左边路径总数（相信他能算出来）
        int rightPathSum = pathSum_1(root.right, sum); // 右边路径总数（相信他能算出来）
        return leftPathSum + rightPathSum + pathImLeading;
    }
    int count_1(TreeNode node, int sum) {
        if (node == null) return 0;
        // 我自己能不能独当一面，作为一条单独的路径呢？
        int isMe = (node.val == sum) ? 1 : 0;
        // 左边的小老弟，你那边能凑几个 sum - node.val 呀？
        int leftBrother = count_1(node.left, sum - node.val);
        // 右边的小老弟，你那边能凑几个 sum - node.val 呀？
        int rightBrother = count_1(node.right, sum - node.val);
        return  isMe + leftBrother + rightBrother; // 我这能凑这么多个
    }


}
