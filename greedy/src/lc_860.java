public class lc_860 {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount=0;
        int tenCount=0;
        for (int item : bills){
            if (item==5){
                fiveCount++;
                continue;
            }
            if (item==10){
                if (fiveCount==0){
                    return false;
                }
                fiveCount--;
                tenCount++;
                continue;
            }
            //若收款为20，优先使用10+5找零
            if (item==20){
                if (tenCount>0&&fiveCount>0){
                    tenCount--;
                    fiveCount--;
                    continue;
                }
                if (fiveCount>=3){
                    fiveCount-=3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
