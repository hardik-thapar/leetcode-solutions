class Solution {
    class Pair {
        int r;
        int c;
        int dist;
        Pair(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public int maxDistance(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(grid[i][j]==1) q.add(new Pair(i, j, 0));
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        int res = -1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int k=0; k<4; k++){
                int nr = curr.r + dirs[k];
                int nc = curr.c + dirs[k+1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid.length && grid[nr][nc]==0){
                    grid[nr][nc] = curr.dist+1;
                    res = Math.max(curr.dist+1, res);
                    q.offer(new Pair(nr, nc, curr.dist+1));
                }
            }
        }
        return res;
    }
}