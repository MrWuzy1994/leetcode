package leetcode.lc01000.lc0200;

import javax.swing.tree.TreeNode;

public class Lc0101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return check(root.left,root.right);
    }

    public boolean check(TreeNode left,TreeNode right){
        //递归结束条件
        if ((left != null && right != null) && left.val == right.val){
            return check(left.left,right.right) && check(left.right,right.left);
        }else if (left == null && right == null) {
            return true;
        }else{
            return false;
        }
    }



    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
}
