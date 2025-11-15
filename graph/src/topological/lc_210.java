package topological;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc_210 {
    /**
     * bfs,时间复杂度o(m+n)；空间复杂度o(m+n)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] classes=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            classes[i]=new ArrayList<>();
        }
        int[] inEdge=new int[numCourses];
        for(int[] item : prerequisites){
            classes[item[1]].add(item[0]);
            inEdge[item[0]]++;
        }
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inEdge[i]==0){
                queue.addFirst(i);
            }
        }
        int[] result=new int[numCourses];
        int idx=0;
        while(!queue.isEmpty()){
            Integer classNum=queue.removeLast();
            List<Integer> path=classes[classNum];
            result[idx++]=classNum;
            for(Integer item : path){
                inEdge[item]--;
                if(inEdge[item]==0){
                    queue.addFirst(item);
                }
            }
        }
        return idx==numCourses ? result : new int[0];
    }

    int[] visited;
    boolean valid=true;
    int[] result;
    int idx;

    /**
     * dfs，当搜索到出度为0的节点，将这个节点置于栈底
     * 进行出栈操作，当一个节点的所有出度节点都入栈之后，该节点也可以入栈
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        this.idx=numCourses-1;
        this.result=new int[numCourses];
        this.visited=new int[numCourses];
        List<Integer>[] classes=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            classes[i]=new ArrayList<>();
        }
        for(int[] item : prerequisites){
            classes[item[1]].add(item[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                dfs(i,classes);
                if(!valid){
                    return new int[0];
                }
            }
        }
        return result;
    }
    private void dfs(int num,List<Integer>[] classes){
        visited[num]=1;
        List<Integer> path=classes[num];
        for(Integer item : path){
            if(visited[item]==0){
                dfs(item,classes);
                if(!valid){
                    return;
                }
            }else if(visited[item]==1){
                valid=false;
                return;
            }
        }
        visited[num]=2;
        result[idx--]=num;
    }
}
