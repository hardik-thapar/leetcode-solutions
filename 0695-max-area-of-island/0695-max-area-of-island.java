class Solution {
    int area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    area = Math.max(area,dfs(grid, i, j));
                }
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==0) return 0;
        grid[i][j] = 0;
        return dfs(grid,i-1,j)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1)+1;
    }
}