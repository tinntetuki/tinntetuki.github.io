package org.example;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther:
 * @Date: 2020/5/21 23:15
 * @Description:
 */
class Node{

}

public class BFS {
    static int bfs (Node start, Node target) {
        LinkedBlockingQueue<Node> q = new LinkedBlockingQueue<>();
        Set<Node> visit = new HashSet<>();

        q.offer(start);
        visit.add(start);

        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                if (cur == target){
                    return step;
                }

                //将相邻节点加入队列
               /* for (Node x : cur.) {

                }*/
            }
            step++;
        }
        return 0;
    }

    /**
     *
     * @param
     * @return
     */
   /* int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            *//* 将当前队列中的所有节点向四周扩散 *//*
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                *//* 判断是否到达终点 *//*
                if (cur.left == null && cur.right == null)
                    return depth;
                *//* 将 cur 的相邻节点加入队列 *//*
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            *//* 这里增加步数 *//*
            depth++;
        }
        return depth;
    }*/

    public static void main(String[] args) {

    }
}
