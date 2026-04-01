class Solution:
    def isPalindrome(self, s: str) -> bool:
        ans="".join(i for i in s if i.isalnum())
        ans=ans.lower()
        st=0
        end=len(ans)-1
        while(st<=end):
            if ans[st]!=ans[end]:
                return False
            st+=1
            end-=1
        return True