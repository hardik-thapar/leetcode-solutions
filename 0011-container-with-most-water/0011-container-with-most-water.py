class Solution:
    def maxArea(self, height: List[int]) -> int:
        st=0
        ans=0
        end=len(height)-1
        while(st<end):
            f=height[st]
            s=height[end]
            m=min(f,s)
            dist=end-st
            area=m*dist
            ans=max(area,ans)
            if f<s:
                st+=1
            else:
                end-=1
        return ans

        