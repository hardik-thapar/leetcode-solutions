class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int r = grid.length;
        int c = grid[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    perimeter+=4;
                    if(i>0 && grid[i-1][j]==1) perimeter-=1;
                    if(i<r-1 && grid[i+1][j]==1) perimeter-=1;
                    if(j>0 && grid[i][j-1]==1) perimeter-=1;
                    if(j<c-1 && grid[i][j+1]==1) perimeter-=1;
                }
            }
        }
        return perimeter;
    }
}