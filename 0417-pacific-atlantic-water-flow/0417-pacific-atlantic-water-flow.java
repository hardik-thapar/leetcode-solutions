class Solution {
    private final int[] dirs = {-1,0,1,0,-1};
    private void dfs(int[][] heights, int[][] ocean, int i, int j){
        ocean[i][j] = 1;
        for(int k=0; k<4; k++){
            int nr = i+dirs[k];
            int nc = j+dirs[k+1];
            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && heights[nr][nc]>=heights[i][j] && ocean[nr][nc]!=1){
                dfs(heights, ocean, nr, nc);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0) dfs(heights, pacific, i, j);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==m-1 || j==n-1) dfs(heights, atlantic, i, j);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
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