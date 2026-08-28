class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=0; i<nums.length; i++){
            int res = 0;
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    res = Math.max(res, dp[j]);
                }
            }
            dp[i] = 1+res;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}