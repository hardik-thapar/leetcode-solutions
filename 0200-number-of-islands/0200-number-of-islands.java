class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        if(i < grid.length && i>=0 && j < grid[0].length && j>=0){
            if(grid[i][j]=='1'){
                grid[i][j]='0';
                dfs(grid,i-1,j);
                dfs(grid,i+1,j);
                dfs(grid,i,j-1);
                dfs(grid,i,j+1);
            }
        }
        return;
    }
}