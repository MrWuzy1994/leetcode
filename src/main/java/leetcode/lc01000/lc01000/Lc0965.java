package leetcode.lc01000.lc01000;

public class Lc0965 {

    /**
     * 查找重复元素相当于自动遍历树的过程
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        //遍历树结构
        return xg(root);
    }

    /**
     * 递归方法，判断当前节点的左右子树的根节点的值是否与当前节点相同
     * @param node
     * @return
     */
    public boolean xg(TreeNode node){
        //如果遍历到最后，还是没有发现重复的数据，返回true
        if (node == null)
            return true;
        //当前节点的左子树的根节点的值是否等于当前节点的值
        if (node.left != null && node.val != node.left.val){
            return false;
        }
        //当前节点的右子树的根节点的值是否等于当前节点的值
        if (node.right != null && node.val != node.right.val){
            return false;
        }
        //如果相等，则继续递归左子树和右子树
        return xg(node.left) && xg(node.right);
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
