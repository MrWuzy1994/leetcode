package leetcode.lc02000;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Lc1457 {

    public int pseudoPalindromicPaths (TreeNode root) {
        //先根遍历

        //遍历到树底部判断 数字出现的个数，有多个数字出现奇数次，则失败，
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            map.put(i,0);
        }
        return dg(root,map);

    }

    public Integer dg(TreeNode node, Map<Integer,Integer> numNum ){
        //递归结束条件
        if (node == null){
            int temp = 0;
            for (int i = 1; i <10; i++) {
                if (numNum.get(i) % 2 != 0){
                    temp ++;
                }
            }
            if (temp <= 1){
                return 1 ;
            }else {
                return 0;
            }
        }

        //添加当前节点的值到map中
        numNum.put(node.val,numNum.get(node.val) + 1);
        int temp = 0;
        if (!(node.left == null && node.right == null)){
            if (node.left != null){
                temp +=dg(node.left,numNum);
            }
            if (node.right != null ){
                temp += dg(node.right,numNum);
            }
        }else{
            temp += dg(null,numNum);
        }
        numNum.put(node.val,numNum.get(node.val) - 1);
        return  temp;
    }
    
    public static class TreeNode {
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

    public static void main(String[] args) {
        Integer [] a = new Integer[]{2,3,1,3,1,null,1};
        Queue q = new LinkedList();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(3);
        node2.left = node4;
        TreeNode node5 = new TreeNode(1);
        node2.right = node5;

        TreeNode node7 = new TreeNode(1);
        node3.right = node7;
        Lc1457 lc1457 = new Lc1457();
        lc1457.pseudoPalindromicPaths(node1);
    }
}
