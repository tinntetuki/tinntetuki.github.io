//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 86 👎 0


package leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//Java：N叉树的前序遍历
public class P589NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P589NAryTreePreorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    List<Integer> output = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        tra(root);
        return output;
    }

    private void tra(Node root) {
        if (root != null) {
            output.add(root.val);
            for (Node node : root.children) {
                tra(node);
            }
        }
    }


    public List<Integer> preorder1(Node root) {
        LinkedList<Node> stack  = new LinkedList<>();
        LinkedList<Integer> output= new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.add(root);

        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            output.add(node.val);

            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}