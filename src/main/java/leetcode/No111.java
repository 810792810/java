package leetcode;

/**
 * @Author: xc
 * @Date: 2020/7/19
 *
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7]
 */
public class No111 {
    public static int minDepth(TreeNode root) {
        int h = Integer.MAX_VALUE;
        if (root == null){
            return 0;
        }
        if (root.left == null  && root.right ==null){
            return 1;
        }
        if (root.left !=null){
            h = Math.min(h,minDepth(root.left));
        }
        if(root.right !=null){
            h = Math.min(h,minDepth(root.right));
        }
        return h+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new  TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
