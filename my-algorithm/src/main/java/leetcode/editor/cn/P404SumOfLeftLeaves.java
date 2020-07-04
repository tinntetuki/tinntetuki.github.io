//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 162 👎 0


package leetcode.editor.cn;
//Java：左叶子之和
public class P404SumOfLeftLeaves{
    public static void main(String[] args) {
        Solution solution = new P404SumOfLeftLeaves().new Solution();
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
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }

        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            result += root.left.val;
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return result;
    }

    /*private int sum_left(TreeNode root, boolean falg) {
        if (root == null) {
            return 0;
        }

        if (falg && root.left == null && root.right == null) {
            return root.val;
        }

        int left_sum = sum_left(root.left, true);
        int right_sum = sum_left(root.right, false);

        return left_sum + right_sum;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}