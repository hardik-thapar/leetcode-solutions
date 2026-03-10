class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row=[[False for i in range(9)] for i in range(9)]
        col=[[False for i in range(9)] for i in range(9)]
        box=[[False for i in range(9)] for i in range(9)]

        for i in range(9):
            for j in range(9):
                if(board[i][j]!='.'):
                    num = int(board[i][j])-1
                #  num=int(num)-1
                    k = int((i//3)*3+(j//3))
                    if(row[i][num] or col[j][num] or box[k][num]):
                        return False
                    row[i][num]=col[j][num]=box[k][num]=True
        return True