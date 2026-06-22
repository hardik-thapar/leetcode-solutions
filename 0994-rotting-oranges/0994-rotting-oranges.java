class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        // boolean
        int level = -1;
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1) res++;
            }
        }
        if(res==0) return 0;
        if(q.isEmpty()) return -1;
        
        while(!q.isEmpty()){
            
            int size = q.size();
           
            for(int x=0;x<size;x++){
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                // up
                if(i>0 && grid[i-1][j]==1){
                    grid[i-1][j]=2;
                    res--;
                    q.add(new int[]{i-1,j});
                }
                // down
                if(i<r-1 && grid[i+1][j]==1){
                    grid[i+1][j]=2;
                    res--;
                    q.add(new int[]{i+1,j});
                }
                // left
                if(j>0 && grid[i][j-1]==1){
                    grid[i][j-1]=2;
                    res--;
                    q.add(new int[]{i,j-1});
                }
                // right
                if(j<c-1 && grid[i][j+1]==1){
                    grid[i][j+1]=2;
                    res--;
                    q.add(new int[]{i,j+1});
                }

                // mark[i][j] = true;
            }
            level++;
        }
        if(res==0) return level;
        return -1;
    }
}