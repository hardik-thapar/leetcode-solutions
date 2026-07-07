class Solution {
    class Pair{
        int u;
        int v;
        int cost;
        Pair(int u, int v, int cost){
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
        int n = points.length;
        List<Pair> edges = new ArrayList<>();
        int x = 0;
        int[] parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int cost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                edges.add(new Pair(i,j,cost));
            }
        }
        Collections.sort(edges, (a,b)->Integer.compare(a.cost,b.cost));
        int ans = 0;
        for(Pair edge: edges){
            int p1 = find(edge.u, parent);
            int p2 = find(edge.v, parent);
            if(p1!=p2) {
                parent[p2] = p1;
                ans+=edge.cost;
            }
        }
        return ans;

    }
}