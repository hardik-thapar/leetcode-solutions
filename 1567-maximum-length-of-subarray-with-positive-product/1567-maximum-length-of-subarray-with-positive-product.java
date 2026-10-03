class Solution {
    public int getMaxLen(int[] nums) {
        int res = 0;
        int pos = 0;
        int neg = 0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(num==0){
                pos = 0;
                neg = 0;
            }
            else if (num < 0){
                int temp = pos;
                pos = (neg>0) ? neg+1: 0;
                neg = temp+1;
            }
            else {
                pos++;
                if(neg>0) neg++;
            }
            res = Math.max(res, pos);
        }
        return res;
    }
}