class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        longest=0
        seen=set(nums)
        count=0

        for num in seen:
            if num-1 not in seen:
                count=1
                curr=num
                while(curr+1 in seen):
                    curr+=1
                    count+=1
                    
                longest=max(longest,count)

        return longest
        