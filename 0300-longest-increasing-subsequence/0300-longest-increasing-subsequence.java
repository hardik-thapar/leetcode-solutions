class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = -1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // dp[0]=1;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                   dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

}