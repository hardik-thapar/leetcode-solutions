class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        count=Counter(nums)
        res=[]
        for x,n in count.items():
            if n > (len(nums)/3):
                res.append(x)
        return res