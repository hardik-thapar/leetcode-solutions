class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count=Counter(nums)
        # print(count)
        bucket=[[] for i in range(len(nums)+1)]
        # print(bucket)
        for i,n in count.items():
            bucket[n].append(i)
        # print(bucket)
        res=[]
        i=len(nums)-1
        while(len(res)!=k):
            for x in bucket[i]:
                res.append(x)
            
            i=i-1
        # print(res)
        return res