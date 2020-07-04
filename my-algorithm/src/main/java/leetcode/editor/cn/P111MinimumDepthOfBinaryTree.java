//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;

//Java：二叉树的最小深度
public class P111MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        //广度优先算法
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair<TreeNode, Integer>(root, 1));
        }

        int cur_deep = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.poll();

            root = cur.getKey();
            cur_deep = cur.getValue();

            if (root.left == null && root.right == null) {
                break;
            }

            if (root.left != null) {
                stack.add(new Pair<>(root.left, cur_deep + 1));
            }
            if (root.right != null) {
                stack.add(new Pair<>(root.right, cur_deep + 1));
            }
        }

        return cur_deep;

        //递归
        /*if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }

        int min_deep = Integer.MAX_VALUE;
        if (root.left != null){
            min_deep = Math.min(minDepth(root.left), min_deep);
        }
        if (root.right != null) {
            min_deep = Math.min(minDepth(root.right), min_deep);
        }
        return min_deep + 1;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}