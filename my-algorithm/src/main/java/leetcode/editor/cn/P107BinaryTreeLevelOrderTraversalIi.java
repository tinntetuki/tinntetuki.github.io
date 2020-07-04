//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的层次遍历 II
public class P107BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() > 0){
            List<Integer> treeNodeVal = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.remove();
                treeNodeVal.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.add(treeNode.right);
                }

            }
            res.addFirst(treeNodeVal);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}