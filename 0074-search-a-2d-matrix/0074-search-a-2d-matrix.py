class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])
        st=0
        end=m*n-1
        while(st<=end):
            mid=(st+end)//2
            row=mid//n
            col=mid%n
            if matrix[row][col]==target:
                return True
            elif matrix[row][col]<target:
                st=mid+1
            else:
                end=mid-1
        return False