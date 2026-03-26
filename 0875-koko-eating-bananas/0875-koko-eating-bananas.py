class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # res=[i for i in range(1,max(piles))]
        st=1
        ans=[]
        end=max(piles)
        while(st<=end):
            mid=(st+end)//2
            speed=mid
            total_hours = 0
            for i in piles:
                total_hours+=ceil(i/speed)
            if total_hours <= h:
                ans.append(speed)
                end=mid-1
            else:
                st=mid+1
        return min(ans)

            


        
