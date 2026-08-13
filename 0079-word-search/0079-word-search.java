class Solution {
    private int r;
    private int c;
    private boolean ans = false;
    private int[] dirs = {-1,0,1,0,-1};
    private void dfs(int i, int j, char[][] board, char[] words, int index){
        if(ans) return;
        if(index==words.length){
            ans = true;
            return;
        }
        char og = board[i][j];
        board[i][j] = '0';
        for(int k=0; k<4; k++){
            int nr = i + dirs[k];
            int nc = j + dirs[k+1];
            if(nr<0 || nr>r-1 || nc<0 || nc>c-1 || board[nr][nc]=='0') continue;
            if(board[nr][nc]==words[index]){
                // char og = board[nr][nc];
                // board[nr][nc] = '0';
                dfs(nr, nc, board, words, index+1);
                // board[nr][nc] = og;
                if(ans) return;
            }
        }
        board[i][j] = og;
        return;
    }

    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;
        char[] words = word.toCharArray();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j]==words[0]){
                    dfs(i, j, board, words, 1);
                }
            }
        }
        return ans;
    }
}