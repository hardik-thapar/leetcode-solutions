class Solution {
    class Pair{
        int i;
        int j;
        int obstacles_removed;
        int steps;
        Pair(int i, int j, int obstacles_removed, int steps){
            this.i = i;
            this.j = j;
            this.obstacles_removed = obstacles_removed;
            this.steps = steps;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        // """
        // state: (i,j, obstacles removed)
        // dist: i,j, obstacles removed to reach that node
        // pq: i,j, steps,obstacles removed

        // """
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dist = new int[m][n][k+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dist[i][j],Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.steps,b.steps));
        dist[0][0][0] = 0;
        pq.offer(new Pair(0,0,0,0));
        int[] dirs = {-1,0,1,0,-1};
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.i==m-1 && curr.j==n-1) return curr.steps;
            if(curr.steps > dist[curr.i][curr.j][curr.obstacles_removed]) continue;
            for(int x=0; x<4; x++){
                int nr = curr.i + dirs[x];
                int nc = curr.j + dirs[x+1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int t_obs = curr.obstacles_removed + grid[nr][nc];
                    int t_steps = curr.steps + 1;
                    if(t_obs < k+1 && t_steps < dist[nr][nc][t_obs]){
                        dist[nr][nc][t_obs] = t_steps;
                        pq.offer(new Pair(nr,nc,t_obs,t_steps));
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<k+1; i++){
            res = Math.min(res,dist[m-1][n-1][i]);
        }
        if(res==Integer.MAX_VALUE) return -1;
        return res;


    }
}