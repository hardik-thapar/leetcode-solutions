class Solution {
    private int dfs(int r, int c, int[][] memo, int m, int n){
        if(r==m-1 && c==n-1){
            return 1;
        }
        if(memo[r][c]!=-1) return memo[r][c];
        memo[r][c] = 0;
        if(r+1 < m) memo[r][c] += dfs(r+1, c, memo, m, n);
        if(c+1 < n) memo[r][c] += dfs(r, c+1, memo, m, n);
        return memo[r][c];
    }
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, memo, m, n);
    }
}