import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class lc_406 {
    public int[][] reconstructQueue(int[][] people) {
        //按照升高倒序排列，如果升高相同i[1]更小的放在外面
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        //逐步插入元素，先设置升高较高的，这样即便更矮的元素放到前面，也不会对高个子元素产生影响
        List<int[]> list = new LinkedList<>();
        for (int[] item : people) {
            list.add(item[1], item);
        }
        return list.toArray(new int[people.length][]);
    }

}
