class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        ans=[]
        st=1
        end=max(piles)
        while(st<=end):
            mid=(st+end)//2
            speed=mid
            t=0
            for i in piles:
                t+=ceil(i/speed)
            if t<=h:
                ans.append(speed)
                end=mid-1
            else:
                st=mid+1
        return min(ans)