class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count={}
        st=0
        max_freq=0
        max_len=0

        for end in range(len(s)):
            count[s[end]]=1+count.get(s[end],0)
            max_freq=max(max_freq,count[s[end]])

            while (end-st+1) - max_freq >k:
                count[s[st]]-=1
                st+=1
            max_len=max(max_len,end-st+1)
        return max_len