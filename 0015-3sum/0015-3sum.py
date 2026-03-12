class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums=sorted(nums)
        res=[]
        for i in range(len(nums)):
            if(i>0 and nums[i]==nums[i-1]):
                continue
            
            idx=i+1
            j=len(nums)-1
            while(idx<j):
                if(nums[i]+nums[idx]+nums[j]==0):
                    res.append([nums[i],nums[idx],nums[j]])
                    idx+=1
                    j-=1
                    while(idx<j and nums[idx]==nums[idx-1]):
                        idx+=1
                    while(j<len(nums)-2 and nums[j]==nums[j+1]):
                        j-=1
                elif(nums[i]+nums[idx]+nums[j]<0):
                    idx+=1
                else:
                    j-=1
                
        return res          

            