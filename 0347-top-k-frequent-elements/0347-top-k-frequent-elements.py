class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n=len(nums) #max freq of any element can be n
        freq={}
        for i in nums:
            freq[i]=freq.get(i,0)+1
        res=[[] for i in range(n+1)]

        for num,f in freq.items():
            res[f].append(num)
        ans=[]
        i=len(nums)-1
        while(len(ans)<k):
            for num in res[i]:
                ans.append(num)
                if len(ans)==k:
                    return ans
            i-=1
        return ans





        