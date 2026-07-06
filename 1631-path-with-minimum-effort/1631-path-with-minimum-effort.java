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
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.value,b.value));
        dist[0][0] = 0;
        pq.offer(new Pair(0,0,0));
        int[] dirs = {-1,0,1,0,-1};
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.value > dist[curr.i][curr.j]) continue;
            for(int k=0; k<4; k++){
                int nr = curr.i + dirs[k];
                int nc = curr.j + dirs[k+1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int d = Math.max(curr.value,Math.abs(heights[nr][nc] - heights[curr.i][curr.j]));
                    if(d < dist[nr][nc]){
                        dist[nr][nc] = d;
                        pq.offer(new Pair(nr,nc,d));
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}