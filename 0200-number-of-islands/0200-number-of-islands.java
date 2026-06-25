class Solution {
    void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] d: dir){
            int nr = i+d[0];
            int nc = j+d[1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1') dfs(grid,nr,nc);
        }
        return;

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ans++;}
            }
        }
        return ans;
    }
}