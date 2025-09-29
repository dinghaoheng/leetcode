import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lc_332 {

    public static void main(String[] args) {
        List<String> path1=Arrays.asList("MUC","LHR");
        List<String> path2=Arrays.asList("JFK","MUC");
        List<String> path3=Arrays.asList("SFO","SJC");
        List<String> path4=Arrays.asList("LHR","SFO");
        List<List<String>> list=Arrays.asList(path1,path2,path3,path4);
        new lc_332().findItinerary(list);
    }

    LinkedList<String> path=new LinkedList<>();
    List<List<String>> tickets;
    boolean[] used;

    /**
     * 使用回溯会超时，必须用图
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        //对于机票list，按照每个机票的终点字典顺序进行排序
        Collections.sort(tickets, (o1, o2) -> o1.get(1).compareTo(o2.get(1)));
        this.tickets=tickets;
        this.used=new boolean[tickets.size()];
        dfs();
        return path;
    }
    private boolean dfs(){
        if (path.size()==tickets.size()-1){
            return true;
        }
        for (int i=0;i<tickets.size();i++){
            if (used[i]){
                continue;
            }
            List<String> ticket=tickets.get(i);
            if (!path.get(path.size()-1).equals(ticket.get(0))){
                continue;
            }
            used[i]=true;
            path.add(ticket.get(1));
            if (dfs()){
                return true;
            }
            used[i]=false;
            path.removeLast();
        }
        return false;
    }
}
