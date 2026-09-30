class Solution {
    public int getMaxLen(int[] nums) {
        int max = 0, pos = 0, neg = 0;
        for(int num: nums){
            if(num==0){
                pos=0;
                neg=0;
            }
            else if(num > 0){
                pos++;
                if(neg>0) neg++;
            }
            else {
                int old = pos;
                pos = (neg>0) ? neg+1 : 0;
                neg = old+1;
            }
            max = Math.max(max, pos);
        }
        return max;
    }
}