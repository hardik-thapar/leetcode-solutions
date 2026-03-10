class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        res=[]
        if(len(nums)==1): 
            res.append(nums[0])
            return res

        count={}
        freq=[[] for i in range(len(nums)+1)]
        for n in nums:
            count[n]=1+count.get(n,0)
        for n,c in count.items():
            freq[c].append(n)
        
        for i in range(len(freq)-1,0,-1):
            for x in freq[i]:
                res.append(x)
                if(len(res)==k): return res

        
        