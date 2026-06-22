class Solution {
    public void solve(char[][] board) {

        
        int r = board.length;
        int c = board[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if((i==0 || i==r-1 || j==0 || j==c-1) && board[i][j]=='O'){
                    dfs(board, i, j);
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='T'){
                    board[i][j] = 'O';
                }
                else board[i][j]='X';
                }
            }
            return;
        }
    

    public void dfs(char[][] board, int i, int j){
        if(board[i][j]=='T') return;
        board[i][j] = 'T';
        if(i>0 && board[i-1][j]=='O') dfs(board,i-1,j);
        if(i<board.length-1 && board[i+1][j]=='O') dfs(board,i+1,j);
        if(j>0 && board[i][j-1]=='O') dfs(board,i,j-1);
        if(j<board[0].length-1 && board[i][j+1]=='O') dfs(board,i,j+1);
        return;
    }
}