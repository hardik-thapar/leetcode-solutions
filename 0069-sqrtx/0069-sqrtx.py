class Solution:
    def mySqrt(self, x: int) -> int:
        st=0
        end=x
        m=0
        while(st<=end):
            mid=int((st+end)/2)
            if mid*mid<=x:
                st=mid+1
                m=mid
            else:
                end=mid-1
        return m  
       