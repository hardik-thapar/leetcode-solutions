class Solution {
    public int maxScore(int[] nums, int k) {
        //took hint 1; we count total sum, then maintain a window of size n-k, then keep movinbg that window as a subarr, then kep track of the max sum as t_sum - sum of window.
        int t_sum = 0;
        for(int i=0; i<nums.length; i++) t_sum+=nums[i];
        if(k>=nums.length) return t_sum;
        int st = 0;
        int sum = 0;
        int res = 0;
        for(int end = 0; end<nums.length; end++){
            sum+=nums[end];
            while(end-st+1 > nums.length - k){
                sum-=nums[st];
                st++;
            }
            if(end-st+1 == nums.length-k) res = Math.max(res, t_sum - sum);
        }
        return res;
    }
}