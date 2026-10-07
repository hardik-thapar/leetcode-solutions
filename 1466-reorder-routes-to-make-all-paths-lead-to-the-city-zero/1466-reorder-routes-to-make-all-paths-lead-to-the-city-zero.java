class Solution {
    class Edge {
        int to;
        boolean point;
        Edge(int to, boolean point){
            this.to = to;
            this.point = point;
        }
    }
    private int res = 0;
    private void dfs(int idx, List<Edge>[] adj, boolean[] visited){
        if(idx==adj.length) return;
        visited[idx] = true;
        for(Edge nbr: adj[idx]){
            if(visited[nbr.to]==false) {if(nbr.point==false) res++;
            dfs(nbr.to, adj, visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<Edge>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int[] e: connections){
            int u = e[0];
            int v = e[1];
            adj[u].add(new Edge(v, false));
            adj[v].add(new Edge(u, true));
        }
        dfs(0, adj, visited);
        return res;
    }
}