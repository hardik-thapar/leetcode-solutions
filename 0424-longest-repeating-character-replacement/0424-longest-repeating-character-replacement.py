class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count={}
        i=0
        max_freq=0
        max_len=0
        for r in range(len(s)):
            count[s[r]]=count.get(s[r],0)+1
            max_freq=max(max_freq,count[s[r]])
            while(r-i+1)-max_freq>k:
                count[s[i]]-=1
                i+=1
            max_len=max(max_len,r-i+1)
        return max_len