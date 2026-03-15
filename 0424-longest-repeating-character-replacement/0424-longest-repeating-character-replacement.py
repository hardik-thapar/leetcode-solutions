class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_freq=0
        l=0
        freq={}
        ml=0
        for r in range(len(s)):
            freq[s[r]]=freq.get(s[r],0)+1
            max_freq=max(max_freq,freq[s[r]])
            while(r-l+1) - max_freq> k:
                freq[s[l]]-=1
                l+=1
            ml=max(ml,r-l+1)
        return ml


