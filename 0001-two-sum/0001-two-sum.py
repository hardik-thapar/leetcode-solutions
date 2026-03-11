class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen={}
        for i,num in enumerate(nums):
            req = target-num
            if req in seen:
                return [seen[req],i]
            seen[num]=i