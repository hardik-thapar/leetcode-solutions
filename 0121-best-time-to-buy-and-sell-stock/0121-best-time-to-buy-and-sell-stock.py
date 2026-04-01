class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #min
        m = prices[0]
        profit=0
        for today in range(1,len(prices)):
            cp=prices[today]-m
            profit=max(cp,profit)
            m=min(prices[today],m)
        return profit




        