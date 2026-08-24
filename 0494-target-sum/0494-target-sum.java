class Solution {
    private int offset = 1000;
    private int dfs(int idx, int target, int[] nums, int[][] dp){
        if(idx==nums.length){
            if(target==0) return 1;
            return 0;
        }
        if(target<-1000 || target>1000) return 0;
        if(dp[idx][target+offset]!=-1) return dp[idx][target+offset];
        dp[idx][target+offset] = dfs(idx+1, target-nums[idx], nums, dp) + dfs(idx+1, target+nums[idx], nums, dp);
        return dp[idx][target+offset];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, target, nums, dp);
    }
}