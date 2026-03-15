class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        k=len(s1)
        f1=Counter(s1)
        f2={}
        l=0
        for r in range(len(s2)):
            f2[s2[r]]=f2.get(s2[r],0)+1
            while(r-l+1 > k):
                if s2[l] in f2:
                    f2[s2[l]]-=1
                    if f2[s2[l]]<=0:
                        del f2[s2[l]]
                l+=1
            if f1==f2:
                return True
        return False
    
     