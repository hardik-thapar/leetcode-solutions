class Solution {
    private int dfs(int idx, int target, int[] coins, int[][] dp){
        if(idx==coins.length){
            if(target==0) return 0;
            return Integer.MAX_VALUE;
        }
        if(target==0) return 0;
        if(target<0) return Integer.MAX_VALUE;
        if(dp[idx][target]!=-1) return dp[idx][target];
        int take = dfs(idx, target-coins[idx], coins, dp);
        if(take!=Integer.MAX_VALUE) take+=1;
        int skip = dfs(idx+1, target, coins, dp);
        dp[idx][target] = Math.min(take, skip);
        return dp[idx][target];
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int res = dfs(0, amount, coins, dp);
        if(res!=Integer.MAX_VALUE) return res;
        return -1;
    }
}