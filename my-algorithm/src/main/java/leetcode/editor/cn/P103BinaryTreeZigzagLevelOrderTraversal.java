//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的锯齿形层次遍历
public class P103BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);
        queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<>();
        boolean is_order_left = true;

        while (queue.size() > 0){
           TreeNode cur_node = queue.pollFirst();
            if (cur_node != null) {
                if (is_order_left){
                    level_list.addLast(cur_node.val);
                } else {
                    level_list.addFirst(cur_node.val);
                }

                if (cur_node.left != null) {
                    queue.addLast(cur_node.left);
                }
                if (cur_node.right != null){
                    queue.addLast(cur_node.right);
                }
            } else {
                res.add(level_list);
                level_list = new LinkedList<>();

                if (queue.size() > 0) {
                    queue.addLast(null);
                }

                is_order_left = !is_order_left;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}