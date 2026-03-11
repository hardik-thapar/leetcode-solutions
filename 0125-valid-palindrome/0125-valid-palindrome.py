class Solution:
    def isPalindrome(self, s: str) -> bool:
        w=''.join(s.lower())
        res = ''.join([char for char in w if char.isalnum()])
        i=0
        j=len(res)-1
        while(i<j):
            if(res[i]!=res[j]):
                return False
            i+=1
            j-=1
        return True
