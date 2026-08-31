class Solution {
    private int dfs(int idx, int target, int[] coins, int[][] memo){
        if(idx==coins.length){
            if(target==0) return 0;
            return Integer.MAX_VALUE;
        }
        if(target==0) return 0;
        if(target<0) return Integer.MAX_VALUE;
        if(memo[idx][target]!=-1) return memo[idx][target];
        int take = dfs(idx, target-coins[idx], coins, memo);
        if(take != Integer.MAX_VALUE) take+=1;
        int skip = dfs(idx+1, target, coins, memo);
        memo[idx][target] = Math.min(take, skip);
        return memo[idx][target];
    }
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++) Arrays.fill(memo[i], -1);
        int res = dfs(0, amount, coins, memo);
        if(res!=Integer.MAX_VALUE) return res;
        return -1;
    }
}