class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        i=1
        profit=0
        while(i<len(prices)):
            buy=min(buy,prices[i])
            cp=prices[i]-buy
            profit=max(cp,profit)
            i+=1
           
        return profit
