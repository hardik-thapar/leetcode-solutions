class Solution {
    public int maxProfit(int[] prices) {
        int m = prices[0];
        int profit = 0;
        for(int x: prices){
            int curr = x - m;
            profit = Math.max(profit, curr);
            m = Math.min(m,x);
        }
        return profit;
    }
}