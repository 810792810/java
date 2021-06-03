package leetcode.no1_100;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 左-根-右
 */
public class No94 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,new TreeNode(6),null));

        for (Integer i :  inorderTraversal(treeNode)) {
            System.out.printf(i +", " );
        }
        System.out.println();
        for (Integer i : inorderByWhile(treeNode)) {
            System.out.printf(i +", " );
        }
    }

    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);;
        return list;
    }

    /**
     * 递归
     */
    static public void inorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    /**
     * 迭代
     * 通过栈实现
     */
    static public List<Integer> inorderByWhile(TreeNode root){
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList();
        while (root != null || !linkedList.isEmpty()){
            while (root != null) {
                linkedList.push(root);
                root = root.left;
            }
            root = linkedList.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}




