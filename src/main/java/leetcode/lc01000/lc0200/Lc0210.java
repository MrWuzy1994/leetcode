package leetcode.lc01000.lc0200;

import java.util.*;

public class Lc0210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //节点和邻近节点的关系
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        //入度
        int indegree []  = new int [numCourses] ;
        //结果
        int [] toplogicalOrder = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        //构造先修关系和入度
        for (int i = 0; i < prerequisites.length; i++) {
            //源节点
            int src = prerequisites[i][1];
            //指向节点
            int dest = prerequisites[i][0];
            //映射关系，key为源节点，value为指向节点的list集合
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            //添加指向节点
            lst.add(dest);
            //添加关系到map集合
            adjList.put(src,lst);
            //指向节点的指如数加1 （表示指向节点多了一个箭头指向他，所以入度+1）
            indegree[dest] += 1;
        }
        //添加入度为零的节点到队列
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int index = 0;
        while (!q.isEmpty()){
            //第一个元素出队
            Integer node = q.poll();
            //出队元素添加添加到结果集中
            toplogicalOrder[index++]=node;
            //遍历出队元素所指向的元素使这些元素的入度-1
            List<Integer> keys = adjList.get(node);
            for (int i = 0; keys != null && i < keys.size(); i++) {
                //获取底i个元素
                Integer integer = keys.get(i);
                //入度-1
                indegree[integer] = indegree[integer] - 1;
                //如果元素的入度为0，添加到队列中
                if (indegree[integer] == 0){
                    q.offer(integer);
                }
            }
        }
        //节点是否都添加到结果集中，如果全部添加到结果集，则结果正确，否则，则不能修完全部课程
        return index == numCourses ? toplogicalOrder : new int[0];
    }

    public static void main(String[] args) {
        //int [][] a = new int[][]{{1,0},{2,3},{3,2}};
        int [][] a = new int[][]{{0,1}};
        findOrder(2,a);
    }
}
