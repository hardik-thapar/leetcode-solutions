class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        f1 = Counter(s1)
        f2 = {}
        st=0
        for end in range(len(s2)):
            f2[s2[end]]=1+f2.get(s2[end],0)
            while(end-st+1 > len(s1)):
                if s2[st] in f2:
                    f2[s2[st]]-=1
                    if(f2[s2[st]]<=0):
                        del f2[s2[st]]
                st+=1
            if(f1==f2):
                return True
        return False