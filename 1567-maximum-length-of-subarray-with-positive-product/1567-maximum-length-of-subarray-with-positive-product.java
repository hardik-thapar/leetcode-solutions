class Solution {
    public int getMaxLen(int[] nums) {
        int pos=0;
        int neg=0;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            //case 1: 0
            if(num==0){
                pos=0;
                neg=0;
            }
            //case 2: +ve
            else if(num>0){
                if(neg>0) neg+=1;
                pos++;
            }
            else {
                int temp = pos;
                pos = (neg>0)? neg+1:0;
                neg = temp+1;
            }
            res = Math.max(res, pos);
        }
        return res;
    }
}