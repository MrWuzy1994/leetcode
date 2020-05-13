package leetcode.lc01000.lc0200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc0102 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 相当于一个二叉树的广度优先遍历
     *  利用队列的性质，把当前深度的节点遍历一遍，然后把当前节点的左右子元素添加到队尾
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果集合
        List<List<Integer>> result = new ArrayList<>();
        //如果没有节点，直接返回
        if (root == null)
            return result;
        //队列
        Queue<TreeNode> q = new LinkedList();
        //把根节点添加到队列
        q.add(root);
        //判断当前队列的元素个数是否大于零
        while (q.size() > 0){
            //获取队列在当前深度的元素个数
            int once = q.size();
            //存储当前深度的元素集合
            List<Integer> list = new ArrayList<>();
            //当前深度的元素出队，然后把当前深度的每个元素的左右子节点依次添加到队尾
            for (int i = 0; i < once; i++) {
                //出队
                TreeNode treeNode = q.poll();
                list.add(treeNode.val);
                //添加左子树入队
                TreeNode left = treeNode.left;
                if (left != null){
                    q.add(left);
                }
                //添加右字数入队
                TreeNode right = treeNode.right;
                if (right != null){
                    q.add(right);
                }
            }
            //当前深度的所有元素添加到结果集合
            result.add(list);
        }
        return result;
    }
}
