//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 118 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉搜索树中的众数
public class P501FindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();
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
    int maxCount=0;
    int count=0;
    List<Integer> res=new ArrayList<>();
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        preOrder(root);
        if(this.count==this.maxCount){
            //把最后的节点加进去
            res.add(pre.val);
        }else if(this.count>this.maxCount){
            //说明最后遍历的那个元素是最多的，因此直接替换
            res=new ArrayList<>();
            res.add(pre.val);
        }
        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }

    public void preOrder(TreeNode root){
        if(root != null){
            preOrder(root.left);
            if(pre != null){
                if(root.val != pre.val){  // 当前节点如果和上次节点不一致，说明相同值的节点结束了，因此需要比较和计算
                    if(count>maxCount){ //结束的节点比之前的节点更多，则更新为最新值
                        maxCount = count;
                        res=new ArrayList<>();
                        res.add(pre.val);
                    } else if(count == maxCount){
                        //结束的节点与之前的节点相同，则添加最新值
                        res.add(pre.val);
                    }
                    //将当前节点root统计次数=1
                    count=1;
                }else{
                    //当前节点如果和上次节点一致,则直接统计节点数目
                    count++;
                }
            }else{
                //说明访问到了最左边的节点，此时才真正开始统计
                count=1;
            }
            pre = root;
            preOrder(root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}