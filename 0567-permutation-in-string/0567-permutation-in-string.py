class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        st=0
        end=len(s1)-1
        while end<len(s2):
            s3=s2[st:end+1]
            if(Counter(s3)==Counter(s1)):
                return True
            st+=1
            end+=1
        return False
                
            
