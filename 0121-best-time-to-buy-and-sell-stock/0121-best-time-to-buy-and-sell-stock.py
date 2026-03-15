class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy=prices[0]
        profit=0
        for i in range(1,len(prices)):
            num=prices[i]
            cp = num-buy
            profit = max(profit,cp)
            buy=min(num,buy)
        return profit