class Solution {

    public void dfs(int[][] heights, int i, int j, boolean[][] mark){
        if(mark[i][j]) return;
        mark[i][j] = true;
        // left
        if(i-1>=0 && heights[i-1][j]>=heights[i][j]) dfs(heights,i-1,j,mark);
        // right
        if(i+1<heights.length && heights[i+1][j]>=heights[i][j]) dfs(heights,i+1,j,mark);
        // up
        if(j-1>=0 && heights[i][j-1] >= heights[i][j]) dfs(heights,i,j-1,mark);
        // down
        if(j+1<heights[0].length && heights[i][j+1] >= heights[i][j]) dfs(heights,i,j+1,mark);
        return;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];
        
        // pacific 
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 || j==0){
                    dfs(heights,i,j,pacific);
                }
            }
        }

        // atlantic 
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==r-1 || j==c-1){
                    dfs(heights,i,j,atlantic);
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(pacific[i][j] && atlantic[i][j]){
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