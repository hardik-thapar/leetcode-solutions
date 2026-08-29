class Solution {
    private int dfs(int i, int canBuy, int[] prices, int[][] memo){
        // 1-> true, 0-> false
        if(i==prices.length) return 0;
        if(memo[i][canBuy]!=-1) return memo[i][canBuy];
        if(canBuy==1) memo[i][canBuy] = Math.max(dfs(i+1, 0, prices, memo) - prices[i], dfs(i+1, 1, prices, memo));
        else memo[i][canBuy] = Math.max(prices[i], dfs(i+1, 0, prices, memo)); 
        return memo[i][canBuy];
    }
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int i=0; i<prices.length; i++) Arrays.fill(memo[i], -1);
        return dfs(0, 1, prices, memo);
    }
}