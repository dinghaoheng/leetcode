public class lc_287 {
    public int findDuplicate(int[] nums) {
        //由于nums[i]属于[1,n]，所以用nums[i]作为idx，不会越界
        //有一个图有n+1个节点，编号从0到n
        //从i->nums[i]连一条边，如果一个nums[i]有两个入度，说明这个数存在了两次，也就是找环的入口
        int slow=0;
        int fast=0;
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            //找到了环
            if(slow==fast){
                break;
            }
        }
        int start=0;
        while(start!=fast){
            start=nums[start];
            fast=nums[fast];
        }
        //相遇时nums[p]=nums[q],重复的就是nums[p]，
        //如果返回nums[start],指向的是下一个数
        return start;
    }
}
