class Solution:
    def minWindow(self, s: str, t: str) -> str:
        countT={}
        for i in t:
            countT[i]=1+countT.get(i,0)
        window={}
        have=0
        need=len(countT)
        res=[-1,-1]
        resLen=float(inf)
        l=0
        for r in range(len(s)):
            c = s[r]
            window[c] = 1+ window.get(c,0)
            if c in countT and window[c]==countT[c]:
                have+=1
            while(have==need):
                if (r-l+1) < resLen:
                    resLen=r-l+1
                    res[0]=l
                    res[1]=r

                window[s[l]]-=1
                if s[l] in countT and window[s[l]]<countT[s[l]]:
                    have-=1
                l+=1
        return s[res[0]:res[1]+1]     