class Solution {
    class Edge{
        int to;
        boolean flag;
        Edge(int to, boolean flag){
            this.to = to;
            this.flag = flag;
        }
    }
    private int res = 0;
    private void dfs(int idx, List<Edge>[] adj, boolean[] visited){
        if(idx==visited.length) return;
        visited[idx] = true;
        for(int i=adj[idx].size()-1; i>=0; i--){
            Edge nbr = adj[idx].get(i);
            if(visited[nbr.to]!=true){
            if(nbr.flag==true){
                nbr.flag = false;
                res++;
            }
            dfs(nbr.to, adj, visited);
            }
        }
        return;
    }
    public int minReorder(int n, int[][] edges) {
        List<Edge>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(new Edge(v, true));
            adj[v].add(new Edge(u, false));
        }
        dfs(0, adj, visited);
        return res;
    }
}