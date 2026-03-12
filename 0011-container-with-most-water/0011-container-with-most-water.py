class Solution:
    def maxArea(self, height: List[int]) -> int:
        area=0
        i=0
        j=len(height)-1
        while(i<j):
            st=height[i]
            end=height[j]
            h=min(st,end)
            dist=j-i
            n_area=dist*h
            area=max(area,n_area)
            if(st<end):
                i+=1
            else:
                j-=1
        return area