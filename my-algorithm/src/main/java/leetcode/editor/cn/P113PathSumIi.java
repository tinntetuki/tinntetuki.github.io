//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：路径总和 II
public class P113PathSumIi{
    public static void main(String[] args) {
        Solution solution = new P113PathSumIi().new Solution();
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, sum, path, res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        sum -= root.val;

        path.add(root.val);

        if (sum == 0 && root.left ==null && root.right == null) {
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        pathSum(root.left, sum, path, res);
        pathSum(root.right, sum, path, res);
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}