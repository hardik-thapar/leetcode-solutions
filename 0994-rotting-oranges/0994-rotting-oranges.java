class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rotten = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    rotten++; 
                    }
            }
        }
        if(rotten==0 && fresh==0) return 0;
        if(rotten==0) return -1;
        if(fresh==0) return 0;
        
        int[] dirs = {-1,0,1,0,-1};
        int level = -1;
        while(!q.isEmpty()){
            int size= q.size();
            for(int x=0; x<size; x++){
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];
                for(int k=0; k<4; k++){
                    int nr = i+dirs[k];
                    int nc = j+dirs[k+1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            level++;
        }
        if(fresh==0) return level;
        return -1;
    }
}