class Solution {
    private int dfs(int idx, int canBuy, int[] prices, int[][] memo){
        if(idx==prices.length) return 0;
        if(memo[idx][canBuy]!=-1) return memo[idx][canBuy];
        // if canBuy -> 1; we can buy or wait
        if(canBuy==1){
            memo[idx][canBuy] = Math.max(dfs(idx+1, 0, prices, memo) - prices[idx], dfs(idx+1, canBuy, prices, memo));
        }
        // if canBuy -> 0; we can sell or wait
        else{
            memo[idx][canBuy] = Math.max(dfs(idx+1, 1, prices, memo) + prices[idx],dfs(idx+1, canBuy, prices, memo));
        }

        return memo[idx][canBuy];
        }
    
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int i=0; i<prices.length; i++) Arrays.fill(memo[i], -1);
        return dfs(0, 1, prices, memo);
    }
}
