class Solution {
    // dfs returns possible ways to reach amount from that idx,amount
    private int dfs(int idx, int target, int[] coins, int[][] memo){
        if(idx==coins.length){
            if(target==0) return 1;
            return 0;
        }
        if(target==0) return 1;
        if(target < 0) return 0;
        if(memo[idx][target]!=-1) return memo[idx][target];
        memo[idx][target] = dfs(idx, target-coins[idx], coins, memo) + dfs(idx+1, target, coins, memo);
        return memo[idx][target];
    }
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, amount, coins, memo);
    }
}