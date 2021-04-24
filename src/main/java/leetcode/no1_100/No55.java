package leetcode.no1_100;

/**
 * @Author: xc
 * @Date: 2021/4/24
 * 二叉树的深度
 *
 * 思路: 后序遍历或层序遍历
 */
public class No55 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,new TreeNode(6),null));

        System.out.println("深度: "+ maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }


    public static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}




