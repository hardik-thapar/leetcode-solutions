class Solution {
    private final int[] dirs = {-1,0,1,0,-1};
    int m;
    int n;
    // int area;
    private int dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;
        int temp = 0;
        for(int x=0; x<4; x++){
            int nr = i+dirs[x];
            int nc = j+dirs[x+1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                temp+=dfs(grid, nr, nc);
            }
        }
        return 1+temp;
    }
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = Integer.MIN_VALUE;
        int area = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    area = Math.max(dfs(grid,i,j), area);   
                }
            }
        }
        return area;
    }
}