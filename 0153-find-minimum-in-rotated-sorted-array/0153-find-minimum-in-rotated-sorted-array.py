class Solution:
    def findMin(self, nums: List[int]) -> int:
        st=0
        end=len(nums)-1
        m=5000
        while(st<=end):
            mid=(st+end)//2
            m=min(m,nums[mid])
            if nums[mid]>nums[end]:
                st=mid+1
            else:
                end=mid-1
        return m
            