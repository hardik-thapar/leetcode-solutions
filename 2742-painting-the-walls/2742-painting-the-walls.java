class Solution {
    private int dfs(int idx, int remaining, int[] cost, int[] time, int[][] dp){
        if(remaining<=0) return 0;
        if(idx==cost.length) return 1_000_000_000;
        if(dp[idx][remaining]!=-1) return dp[idx][remaining];
        return dp[idx][remaining] = Math.min(dfs(idx+1, remaining, cost, time, dp), cost[idx]+dfs(idx+1, remaining-1-time[idx], cost, time, dp));
    }
    public int paintWalls(int[] cost, int[] time) {
        int[][] dp = new int[cost.length][cost.length+1];
        for (int i=0; i<cost.length; i++) Arrays.fill(dp[i], -1);
        return dfs(0, cost.length, cost, time, dp);
    }
}