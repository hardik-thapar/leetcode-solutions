class Solution {
    class Edge{
        int to;
        boolean point;
        Edge(int to, boolean point){
            this.to = to;
            this.point = point;
        }
    }
    private int res = 0;
    private void dfs(int idx, List<Edge>[] adj, boolean[] visited){
        visited[idx] = true;
        for(Edge nbr: adj[idx]){
            if(!visited[nbr.to]){
                visited[nbr.to] = true;
                if(nbr.point==true) res++;
                dfs(nbr.to, adj, visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<Edge>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            adj[u].add(new Edge(v, true));
            adj[v].add(new Edge(u, false));
        }
        boolean[] visited = new boolean[n];
        dfs(0, adj, visited);
        return res;
    }
}