package leetcode.lc01000.lc0200;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class Lc0104 {

    /**
     * 递归法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return countDeep(root,0);
    }

    /**
     * 递归计算左自述的深度和右子数深度的最大值
     * @param node
     * @param deep
     * @return
     */
    public int countDeep(TreeNode node ,int deep){
        //如果当前节点为null，返回深度
        if (node == null){
            return deep;
        }
        //判断左子树的深度和右字数的深度最大值，进行一次调用，深度+1
        return Math.max(countDeep(node.left,deep + 1),
        countDeep(node.right,deep + 1));
    }

    /**
     * 利用栈做操作
     * @return
     */
    public int stackCount(){

        // TODO: 2020/6/2
        return 0;
    }


    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }
}
