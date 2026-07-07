class Solution {
    private class Pair{
        int node;
        int price;
        int stops;
        Pair(int node, int price, int stops){
            this.node = node;
            this.price = price;
            this.stops = stops;
        }}

    private class Edge {
        int node;
        int price;
        Edge(int node, int price){
            this.node = node;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Edge>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] e: flights){
            int from = e[0];
            int to = e[1];
            int price = e[2];
            adj[from].add(new Edge(to,price));
        }

        int[][] dist = new int[n][k+2];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.price,b.price));
        dist[src][0] = 0;
        pq.offer(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.price > dist[curr.node][curr.stops]) continue;
            for(Edge nbr: adj[curr.node]){
                
               int t_cost = curr.price + nbr.price;
               int t_stops = curr.stops+1;

                if(t_stops < k+2 && t_cost < dist[nbr.node][t_stops]){
                    dist[nbr.node][t_stops] = t_cost;
                    pq.offer(new Pair(nbr.node, t_cost, t_stops));
                } 
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<k+2; i++){
            res = Math.min(res,dist[dst][i]);
        }
        if(res==Integer.MAX_VALUE) return -1;
        return res;
    }
}