class Solution {
    private int dfs(int r, int c, int[][] grid, int[][] memo){
        if(r==grid.length-1) return grid[r][c];
        if(memo[r][c]!=101) return memo[r][c];
        memo[r][c] = 0;
        int best = Integer.MAX_VALUE;
        if(c-1 >= 0) best = Math.min(best, dfs(r+1, c-1, grid, memo));
        best = Math.min(best, dfs(r+1, c, grid, memo));
        if(c+1 <= grid[0].length-1) best = Math.min(best, dfs(r+1, c+1, grid, memo));
        memo[r][c] += grid[r][c] + best;
        return memo[r][c];

    }
    public int minFallingPathSum(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            Arrays.fill(memo[i], 101);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<matrix[0].length; i++){
            ans = Math.min(ans, dfs(0, i, matrix, memo));
        }
        return ans;
    }
}