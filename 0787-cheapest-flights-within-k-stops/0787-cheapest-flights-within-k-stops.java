class Solution {
    private class Pair{
        int node;
        int cost;
        int stops;
        Pair(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Pair>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: flights){
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];
            adj[from].add(new Pair(to,price,0));
        }

        // dist[node][stops]
        int[][] dist = new int[n][k+2];
        for(int i=0; i<n; i++){
            for(int j=0; j<k+2; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // PQ(pair)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        dist[src][0] = 0;
        pq.offer(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.cost > dist[curr.node][curr.stops]) continue;
            for(Pair nbr: adj[curr.node]){
                int t_cost = curr.cost + nbr.cost;
                int t_stops = curr.stops + 1;
                if(t_stops < k+2 && t_cost < dist[nbr.node][t_stops]){
                    dist[nbr.node][t_stops] = t_cost;
                    pq.offer(new Pair(nbr.node,t_cost,t_stops));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<k+2; i++){
            res = Math.min(res,dist[dst][i]);
        }
        if(res == Integer.MAX_VALUE) return -1;
        return res;
        
    }
}