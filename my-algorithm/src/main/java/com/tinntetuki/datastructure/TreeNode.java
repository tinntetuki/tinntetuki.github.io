package com.tinntetuki.datastructure;

/**
 * 一句话描述
 *
 * @author tinntetuki
 * @since 2020/7/18
 */
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 遍历二叉树
     * @param root
     */
    void traverse(TreeNode root){
        //操作root
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 节点值加1
     * @param root
     */
    void plusOne(TreeNode root){
        if (root == null) {
            return;
        }

        root.val += 1;

        plusOne(root.left);
        plusOne(root.right);
    }

    /**
     * 判断两个二叉树是否一样
     * @param root1
     * @param root2
     * @return
     */
    boolean isSameTree(TreeNode root1, TreeNode root2){
        //都为空的话，相同
        if (root1 == null && root2 == null){
            return true;
        }

        //一个为空  不同
        if (root1 == null || root2 == null) {
            return false;
        }

        //节点值不一样  不同
        if (root1.val != root2.val) {
            return false;
        }

        //判断左右两边是否一样
        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

    /**
     * BST树：⼀个⼆叉树中，任意节点的值要⼤于等于左⼦树所有节点的值，
     *       且要⼩于等于右边⼦树的所有节点的值
     *
     * 判断BST的合法性
     * @return
     */
    boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    /**
     * 在 BST 中查找⼀个数是否存在
     * @return
     */
    boolean isInBST(TreeNode root, int target){
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        /*return isInBST(root.left, target)
                || isInBST(root.right, target);*/
        if (root.val > target) {
            return isInBST(root.left, target);
        } else {
            return isInBST(root.right, target);
        }
    }

    TreeNode insertBST(TreeNode root, int val){
        //找到空节点的位置插入
        if (root == null){
            return new TreeNode(val);
        }

        if (root.val < val) {
            insertBST(root.right, val);
        }

        if (root.val > val) {
            insertBST(root.left, val);
        }
        return root;
    }

    /**
     * 删除元素
     * @param root
     * @param key
     * @return
     */
    TreeNode deleteNode(TreeNode root, int key){
        if (root.val == key) {
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (right.left != null) {
            node = node.left;
        }
        return node;
    }


    /**
     * 满二叉树  所有节点不为空
     *
     * 输⼊⼀棵完全⼆叉树，返回节点总数
     * @param root
     * @return
     */
    int countNodes(TreeNode root){
        TreeNode l = root, r = root;
        int hl = 0;
        int hr = 0;
        //记录左右数的高度
        while (l != null){
            l = l.left;
            hl++;
        }
        while (r != null){
            r = r .right;
            hr++;
        }
        if (hl == hr){
            return (int)Math.pow(2, hl) -1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 满二叉树的节点数
     * @param root
     * @return
     */
    int countNodes_1(TreeNode root){
        int h = 0;
        while (root != null){
            root = root.left;
            h++;
        }
        return (int)Math.pow(2, h)-1;
    }

}
