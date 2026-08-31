class Solution {
    private int dfs(int idx, int canBuy, int fee, int[] prices, int[][] memo){
        if(idx==prices.length) return 0;
        if(memo[idx][canBuy]!=-1) return memo[idx][canBuy];
        // if we can buy -> then buy or wait
        if(canBuy==1){
            memo[idx][canBuy] = Math.max(dfs(idx+1, 0, fee, prices, memo)-prices[idx], dfs(idx+1, canBuy, fee, prices, memo));
        }
        // if we have to sell -> sell or wait
        else memo[idx][canBuy] = Math.max(dfs(idx+1, 1, fee, prices, memo)+prices[idx]-fee, dfs(idx+1, canBuy, fee, prices, memo));

        return memo[idx][canBuy];
    }
    

    public int maxProfit(int[] prices, int fee) {
        int[][] memo = new int[prices.length][2];
        for(int i=0; i<prices.length; i++) Arrays.fill(memo[i], -1);
        return dfs(0, 1, fee, prices, memo);
    }
}