# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:

        end=n
        st=1
    
        while(st<=end):
            mid=int((st+end)/2)
            res=guess(mid)
            if res == -1:
                end=mid
            elif res==1:
                st=mid+1
            else:
                return mid

        