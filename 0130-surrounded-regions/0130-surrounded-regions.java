class Solution {
    int m;
    int n;
    private final int[] dirs = {-1,0,1,0,-1};
    private void dfs(char[][] board, int i, int j){
        board[i][j] = 'A';
        for(int k=0; k<4; k++){
            int nr = i+dirs[k];
            int nc = j+dirs[k+1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='O'){
                dfs(board, nr, nc);
            }
        }
        return;
    }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j]=='O'){
                    dfs(board, i, j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
        return;
    }
}