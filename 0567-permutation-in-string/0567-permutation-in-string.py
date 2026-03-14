class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        count=Counter(s1)
        win ={}
        i=0
        for j in range(len(s2)):
            win[s2[j]]=win.get(s2[j],0)+1
            while(j-i+1) > len(s1):
                if s2[i] in win:
                    win[s2[i]]-=1
                    if win[s2[i]]<=0:
                        del win[s2[i]]
                i+=1
            if(win==count):
                return True
        return False
