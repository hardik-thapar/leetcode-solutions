class Solution {

    int area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int t = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    area = Math.max(area,dfs(grid,i,j));
                }
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]==1){
            grid[i][j] = -1;
            return dfs(grid,i+1,j) + dfs(grid,i-1,j) + dfs(grid,i,j-1) + dfs(grid,i,j+1) + 1;
        }
        return 0;
    }
}