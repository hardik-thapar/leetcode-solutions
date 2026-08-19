class Solution {
    private int dfs(int r, int c, int[][] grid, int[][] memo){
        if(r==grid.length-1 && c==grid[0].length-1) return grid[grid.length-1][grid[0].length-1];
        if(memo[r][c]!=-1) return memo[r][c];
        memo[r][c] = 0;
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(r+1 < grid.length) down = dfs(r+1, c, grid, memo);
        if(c+1 < grid[0].length) right = dfs(r, c+1, grid, memo);
        memo[r][c] = grid[r][c] + Math.min(right, down);
        return memo[r][c];
    }
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, grid, memo);
    }
}