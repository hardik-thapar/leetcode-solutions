class Solution:
    def isPalindrome(self, s: str) -> bool:
        res=[]
        for char in s.lower():
            c = ord(char)
            if (c>47 and c<58) or (c>96 and c<123):
                res.append(char)
        i=0
        j=len(res)-1
        while(i<j):
            if(res[i]!=res[j]):
                return False
            i+=1
            j-=1
        return True
