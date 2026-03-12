class Solution:
    def trap(self, height: List[int]) -> int:
        area=0
        i=0
        j=len(height)-1
        ml=0
        mr=0
        
        while(i<j):
            ml=max(ml,height[i])
            mr=max(mr,height[j])
            area=area+ml-height[i]
            area=area+mr-height[j]
            if(height[i]<height[j]):
                i+=1
            else:
                j-=1
        return area