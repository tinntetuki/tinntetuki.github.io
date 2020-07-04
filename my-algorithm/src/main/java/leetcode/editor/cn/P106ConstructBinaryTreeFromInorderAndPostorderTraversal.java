//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从中序与后序遍历序列构造二叉树
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        post_idx = postorder.length -1;
        int idx = 0;
        for (Integer val : inorder){
            indexMap.put(val, idx++);
        }

        return helper(0, inorder.length -1);
    }

    private TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right){
            return null;
        }

        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        int index = indexMap.get(root_val);
        post_idx--;

        root.right = helper(index+1, in_right);
        root.left = helper(in_left, index-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}