class Solution {
    public void solve(char[][] board) {

        
        int r = board.length;
        int c = board[0].length;
        boolean[][] mark = new boolean[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if((i==0 || i==r-1 || j==0 || j==c-1) && board[i][j]=='O'){
                    // mark[i][j] = true;
                    dfs(board, i, j, mark);
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mark[i][j]){
                    board[i][j] = 'O';
                }
                else board[i][j]='X';
                }
            }
            return;
        }
    

    public void dfs(char[][] board, int i, int j, boolean[][] mark){
        if(mark[i][j]) return;
        mark[i][j] = true;
        if(i>0 && board[i-1][j]=='O') dfs(board,i-1,j,mark);
        if(i<board.length-1 && board[i+1][j]=='O') dfs(board,i+1,j,mark);
        if(j>0 && board[i][j-1]=='O') dfs(board,i,j-1,mark);
        if(j<board[0].length-1 && board[i][j+1]=='O') dfs(board,i,j+1,mark);
        return;
    }
}