class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        count={}
        for n in s:
            count[n]=1+count.get(n,0)
        for n in t:
            if(count.get(n)):
                count[n]-=1
            else:
                return False
        for i,n in count.items():
            if n!=0:
                return False
        return True
