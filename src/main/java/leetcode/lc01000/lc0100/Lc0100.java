package leetcode.lc01000.lc0100;

public class Lc0100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null){
            return true;
        }
        if (q == null && p != null){
            return false;
        }
        if (q != null && p == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        boolean sameTree = isSameTree(p.left, q.left);
        if (!sameTree){
            return false;
        }
        return isSameTree(p.right, q.right);

    }
}

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



