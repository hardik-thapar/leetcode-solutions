class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        count={}
        for i in nums:
            count[i]=1+count.get(i,0)
        for n,c in count.items():
            if c>1: return True
    
        return False
        