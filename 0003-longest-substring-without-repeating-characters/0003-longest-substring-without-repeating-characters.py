class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        max_len=0
        l=0
        for r in range(len(s)):
            x = s[r]
            if x in seen:
                while x in seen:
                    seen.remove(s[l])
                    l+=1
            seen.add(x)
            cl = r-l+1
            max_len=max(max_len,cl)
        return max_len
                