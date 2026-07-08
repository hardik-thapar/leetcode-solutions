class Solution {
    class Edge {
        int node;
        int cost;
        Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        List<Edge>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj[i].add(new Edge(j,cost));
                adj[j].add(new Edge(i,cost));
            }
        }
        int res = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.offer(new Edge(0,0));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(visited[curr.node]) continue;
            res+=curr.cost;
            visited[curr.node] = true;
            for(Edge nbr: adj[curr.node]){
                pq.offer(new Edge(nbr.node,nbr.cost));
            }

        }
        return res;
    }
}