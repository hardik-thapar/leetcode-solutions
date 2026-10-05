class Solution {

    private int dfs(int idx, int[] nums, int target, int[][] dp){
        if(idx==nums.length){
            if(target==0) return 1;
            return 0;
        }
        if(target<-1000 || target >1000) return 0;
        if(dp[idx][target+1000]!=0) return dp[idx][target+1000];
        dp[idx][target+1000] = dfs(idx+1, nums, target+nums[idx], dp) + dfs(idx+1, nums, target-nums[idx], dp);
        return dp[idx][target+1000];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for(int i=0; i<nums.length; i++) Arrays.fill(dp[i], 0);
        return dfs(0, nums, target, dp);
    }
}