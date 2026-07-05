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
          int[][] cost = new int[m][n];
          for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
          }
          PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.value,b.value));
          cost[0][0] = 0;
          pq.offer(new Pair(0,0,0));
          int[] dirs = {-1,0,1,0,-1};
          while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.value > cost[curr.i][curr.j]) continue;
            for(int k=0; k<4; k++){
                int nr = curr.i + dirs[k];
                int nc = curr.j + dirs[k+1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int curr_cost = Math.max(curr.value,Math.abs(heights[nr][nc]-heights[curr.i][curr.j]));
                    if(curr_cost < cost[nr][nc]){
                        cost[nr][nc] = curr_cost;
                        pq.offer(new Pair(nr,nc,curr_cost));
                    }
                }
            }
          }
          return cost[m-1][n-1];
          
    }
}