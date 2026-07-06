class Solution {
    class Pair{
        int i;
        int j;
        int value;
        Pair(int i, int j, int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
    
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==1 && n==1) return grid[0][0];
        int[][] dist = new int[m][n];
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.value,b.value));
        pq.offer(new Pair(0,0,grid[0][0]));
        int[] dirs = {-1,0,1,0,-1};
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.value > dist[curr.i][curr.j]) continue;
            for(int k=0; k<4; k++){
                int nr = curr.i + dirs[k];
                int nc = curr.j + dirs[k+1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int cost = Math.max(curr.value,grid[nr][nc]);
                    if(cost < dist[nr][nc]){
                        dist[nr][nc] = cost;
                        pq.offer(new Pair(nr,nc,cost));
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }

}