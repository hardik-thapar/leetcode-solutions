class Solution {
    public void dfs(char[][] board, int i, int j){
        board[i][j] = 'A';
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dir : dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc]=='O'){ 
                dfs(board, nr, nc);
            }
        }
        return;
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j] == 'O'){
                    dfs(board,i,j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A'){
                    board[i][j] = 'O';
                }
                else board[i][j] = 'X';
            }
        }
        return;
    }
}