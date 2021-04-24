package leetcode.jzoffer;

import leetcode.model.TreeNode;

/**
 * 判断平衡二叉树
 * 思路: 先序遍历和判断深度
 * 递归 每个节点都判断深度<=1 .   当前节点递归&&递归左子树&&递归右子树
 */
public class No55_2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(7,new TreeNode(6),
                new TreeNode(7,new TreeNode(6),
                new TreeNode(7))))
                ),
                new TreeNode(3,new TreeNode(6),null));
        System.out.println("isBalanced: " + isBalanced(treeNode));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1 )
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right))+1;
    }

}
