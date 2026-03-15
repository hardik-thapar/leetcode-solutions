class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        pre=1
        post=1
        res=[1 for i in range(len(nums))]
        for i in range(len(nums)):
            res[i]=pre
            pre*=nums[i]
        for i in range(len(nums)):
            res[len(nums)-1-i]*=post
            post*=nums[len(nums)-1-i]
        return res