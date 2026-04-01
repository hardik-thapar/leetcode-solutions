class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l=0
        freq={}
        longest=0
        max_freq=0
        for r in range(len(s)):
            freq[s[r]]=freq.get(s[r],0)+1
            max_freq=max(max_freq,freq[s[r]])

            while (r-l+1) - max_freq > k:
                if s[l] in freq:
                    freq[s[l]]-=1
                    if freq[s[l]]<=0:
                        del freq[s[l]]
                l+=1
            longest = max(longest,r-l+1)
        return longest
            

        