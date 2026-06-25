class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int converted = 0;
        int level = -1;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1){
                    grid[i][j]=-1;
                    fresh++;}
            }
        }
        if(fresh==0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0;x<size;x++){
            int[] node = q.poll();
            int i = node[0];
            int j = node[1];
            int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
            for(int[] d: dir){
                int nr = i+d[0];
                int nc = j+d[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==-1){
                    converted++;
                    grid[nr][nc] = 2;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        level++;
        }
        if(converted==fresh) return level;
        return -1;
    }
}