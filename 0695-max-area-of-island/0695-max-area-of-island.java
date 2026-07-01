class Solution {
    private final int[] dirs = {-1,0,1,0,-1};
    int m;
    int n;
    int area;
    private void dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;
        area++;
        for(int x=0; x<4; x++){
            int nr = i+dirs[x];
            int nc = j+dirs[x+1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                dfs(grid, nr, nc);
            }
        }
        return;
    }
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    area = 0;
                    dfs(grid,i,j);
                    res = Math.max(area,res);
                }
            }
        }
        if(area > res) return area;
        return res;
    }
}