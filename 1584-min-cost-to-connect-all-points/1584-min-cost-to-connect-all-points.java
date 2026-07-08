class Solution {
    class Edge {
        int u;
        int v;
        int cost;
        Edge(int u, int v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
    private int find(int node, int[] parent){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node],parent);
    }
    public int minCostConnectPoints(int[][] points) {
        // whenver we have min cost/min price or same to connect all nodes -> we use kruskals algo (we sort the edges and use dsu(find and union)): we sort edges, then we start traversing edges from min cost to max cost, then start checking for an edge(u-v) if leaders of u and v are same then they belong to same group, so adding one more edge creates a cycle and no new node will be connected by that, so we dont union and skip, if leaders are diff that means they belong to diff groups(are not already connected) so we increment total_cost+=cost of that edge and then union them. 
        List<Edge> edges = new ArrayList<>();
        int[] parent = new int[points.length+1];
        for(int i=0; i<points.length+1; i++){
            parent[i] = i;
        }
        for(int i=0; i<points.length; i++){
            for(int j=i; j<points.length; j++){
                int cost = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i,j,cost));
            }
        }
        Collections.sort(edges, (a,b)->Integer.compare(a.cost,b.cost));
        int cost = 0;
        for(Edge edge: edges){
            int p1 = find(edge.u,parent);
            int p2 = find(edge.v,parent);
            if(p1!=p2){
                parent[p2] = p1;
                cost+=edge.cost;
            }
        }

        return cost;
        
    }
}