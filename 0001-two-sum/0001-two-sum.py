class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
      seen = {}
      for i, num in enumerate(nums):
        req = target - num
        if req in seen:
            return [i,seen[req]] 
        seen[num]=i