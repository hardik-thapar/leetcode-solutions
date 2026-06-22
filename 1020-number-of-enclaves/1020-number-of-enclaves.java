class Solution {
    int cnt = 0;
    public void dfs(int[][] grid, int i, int j){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1) return;
        if(grid[i][j]==-1) return;
        if(grid[i][j]==1){
            grid[i][j]=-1;
            cnt++;
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }
        return;
        
    }
    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int t1 = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1) t1++;
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 || i==r-1 || j==0 || j==c-1){
                    if(grid[i][j]==1) dfs(grid,i,j);
                }
            }
        }
        return t1 - cnt;
    }
}