class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int i, int j){
        if(grid[i][j]=='0') return;
        grid[i][j] = '0';
        if(i>0) dfs(grid, i-1, j);
        if(i<grid.length-1) dfs(grid, i+1, j);
        if(j>0) dfs(grid, i, j-1);
        if(j<grid[0].length-1) dfs(grid, i, j+1);
        return;
    }
}