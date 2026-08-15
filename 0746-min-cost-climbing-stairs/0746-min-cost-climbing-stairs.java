class Solution {
    private int dfs(int i, int[] cost, int dp[]){
        if(i>cost.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i] = Math.min(dfs(i+1, cost, dp), dfs(i+2, cost, dp))+cost[i];
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(dfs(0, cost, dp), dfs(1, cost, dp));
    }
}