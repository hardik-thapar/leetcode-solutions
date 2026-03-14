class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        k=len(p)
        f1=Counter(p)
        f2={}
        i=0
        res=[]
        for j in range(len(s)):
            f2[s[j]]=f2.get(s[j],0)+1
            while j-i+1 > k:
                if s[i] in f2:
                    f2[s[i]]-=1
                    if f2[s[i]]<=0:
                        del f2[s[i]]
                i+=1
            if f1==f2:
                res.append(i)
        return res

