public class lc_274 {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] map=new int[n+1];
        for(int i=0;i<n;i++){
            int count=citations[i];
            //这里在n和应用次数之间去最小，目的在于防止越界，理由是次数超过了n没有意义
            map[Math.min(n,count)]++;
        }
        int sum=0;
        //倒序的目的在于，从引用次数多的论文开始算
        for(int i=n;i>=0;i--){
            sum+=map[i];
            if(sum>=i){
                //找到目标后，返回的不是计数次数，而是当前论文的引用次数
                return i;
            }
        }
        return -1;
    }
}
