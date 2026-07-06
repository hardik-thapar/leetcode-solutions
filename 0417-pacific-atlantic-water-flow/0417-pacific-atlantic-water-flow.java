class Solution {
    // we run dfs from all border nodes and track from border moving inwards what cells are connecxted by checking that nbr hheights is more or equal than curr nodes
    private int[] dirs = {-1,0,1,0,-1};
    private int m;
    private int n;
    private void dfs(int[][] grid, int i, int j, boolean[][] ocean){
        ocean[i][j] = true;
        for(int k=0; k<4; k++){
            int nr = i + dirs[k];
            int nc = j + dirs[k+1];
            if(nr>=0 && nr<m && nc>=0 && nc<n){
                if(grid[nr][nc] >= grid[i][j]){
                    if(!ocean[nr][nc]) dfs(grid, nr, nc, ocean);
                }
            }
        }
        return;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp  = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0) dfs(heights,i,j,pacific);
                if(i==m-1 || j==n-1) dfs(heights,i,j,atlantic);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(atlantic[i][j] && pacific[i][j]){
                temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                res.add(temp);
               }
            }
        }
        return res;

    }
}