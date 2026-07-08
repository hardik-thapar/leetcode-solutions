class Solution {
    private class Edge {
        int node;
        int cost;
        Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // weighted directed graph -  use dijkstras
        // we maintain a dist arr, and a pq to always get edge with the min cost, we create a custom class edge having u,v,cost;
        
        List<Edge>[] adj = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: times){
            adj[edge[0]].add(new Edge(edge[1],edge[2]));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        dist[k] = 0;
        pq.offer(new Edge(k,0));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(curr.cost > dist[curr.node]) continue; //stale entry check
            for(Edge nbr: adj[curr.node]){
                if(curr.cost + nbr.cost < dist[nbr.node]){
                    dist[nbr.node] = curr.cost+nbr.cost;
                    pq.offer(new Edge(nbr.node,dist[nbr.node]));
                }
            }
        }
        int res = -1;
        for(int i=1; i<n+1; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            res = Math.max(res,dist[i]);
        }
        if(res==-1) return -1;
        return res;

    }
}