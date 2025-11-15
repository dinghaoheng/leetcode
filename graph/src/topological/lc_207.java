package topological;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc_207 {
    /**
     * 三色标记，0：未访问、1：访问中、2：已访问
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] arr = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            arr[i]=new ArrayList<>();
        }
        for (int[] item : prerequisites) {
            arr[item[1]].add(item[0]);
        }
        int[] color=new int[numCourses];
        //遍历每一门课，判断是否有环
        for (int i=0;i<numCourses;i++){
            if(color[i]==0&&dfs(i,arr,color)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int num, List<Integer>[] arr, int[] color) {
        color[num]=1;
        List<Integer> path=arr[num];
        for (Integer item : path){
            if(color[item]==1){
                return true;
            }
            if(color[item]==0&&dfs(item,arr,color)){
                return true;
            }
        }
        color[num]=2;
        return false;
    }

    /**
     * 广度优先遍历，判断所有的节点的入度是否都为0
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] arr=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            arr[i]=new ArrayList<>();
        }
        int[] inedge =new int[numCourses];
        for(int[] item : prerequisites){
            arr[item[1]].add(item[0]);
            inedge[item[0]]++;
        }
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inedge[i]==0){
                queue.addFirst(i);
            }
        }
        int num=0;
        while(!queue.isEmpty()){
            Integer classNum=queue.removeLast();
            num++;
            List<Integer> path=arr[classNum];
            for(Integer item : path){
                inedge[item]--;
                if(inedge[item]==0){
                    queue.addFirst(item);
                }
            }
        }
        return num==numCourses;
    }
}
