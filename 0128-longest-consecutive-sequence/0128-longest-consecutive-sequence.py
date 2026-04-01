class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen=set(nums)
        longest=0
        for i in seen:
            if i-1 not in seen:
                l=1
                current=i
                while current+1 in seen:
                    l+=1
                    current+=1
                longest=max(l,longest)
        return longest
                