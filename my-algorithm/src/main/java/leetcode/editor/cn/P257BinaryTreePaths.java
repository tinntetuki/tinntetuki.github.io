//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的所有路径
public class P257BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        construct_parh(root, "", paths);
        return paths;
    }

    private void construct_parh(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);

            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                path += "->";

                construct_parh(root.left, path, paths);
                construct_parh(root.right, path, paths);
            }
        }
    }

    /**
     *  LinkedList<String> paths = new LinkedList();
     *         if (root == null)
     *             return paths;
     *
     *         LinkedList<TreeNode> node_stack = new LinkedList();
     *         LinkedList<String> path_stack = new LinkedList();
     *         node_stack.add(root);
     *         path_stack.add(Integer.toString(root.val));
     *         TreeNode node;
     *         String path;
     *         while (!node_stack.isEmpty()) {
     *             node = node_stack.pollLast();
     *             path = path_stack.pollLast();
     *             if ((node.left == null) && (node.right == null))
     *                 paths.add(path);
     *             if (node.left != null) {
     *                 node_stack.add(node.left);
     *                 path_stack.add(path + "->" + Integer.toString(node.left.val));
     *             }
     *             if (node.right != null) {
     *                 node_stack.add(node.right);
     *                 path_stack.add(path + "->" + Integer.toString(node.right.val));
     *             }
     *         }
     *         return paths;
     *
     */
}
//leetcode submit region end(Prohibit modification and deletion)

}