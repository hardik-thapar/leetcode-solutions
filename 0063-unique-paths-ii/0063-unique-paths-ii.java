class Solution {
    private int dfs(int r, int c, int[][] grid, int[][] memo){
        if(r==grid.length-1 && c==grid[0].length-1) return 1;
        if(memo[r][c]!=-1) return memo[r][c];
        memo[r][c] = 0;
        if(r+1 < grid.length && grid[r+1][c]!=1) memo[r][c] += dfs(r+1, c, grid, memo);
        if(c+1 < grid[0].length && grid[r][c+1]!=1) memo[r][c] += dfs(r, c+1, grid, memo);
        return memo[r][c];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, obstacleGrid, memo);
    }
}