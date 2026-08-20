class Solution {
    private int dfs(int r, int c, int[][] grid, int[][] memo){
        if(r==grid.length-1 && c==grid[0].length-1) return grid[r][c];
        if(memo[r][c]!=-1) return memo[r][c];
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        
        if(r+1 <= grid.length-1) down = dfs(r+1, c, grid, memo);
        if(c+1 <= grid[0].length-1) right = dfs(r, c+1, grid, memo);
        if(down==Integer.MAX_VALUE && right==Integer.MAX_VALUE) memo[r][c] = grid[r][c];
        else memo[r][c] = grid[r][c] + Math.min(down, right);
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