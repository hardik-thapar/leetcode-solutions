class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] arr: edges){
            int u = arr[0];
            int v = arr[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(adj,visited,source,destination);
    }

    boolean dfs(ArrayList<Integer>[] adj, boolean[] visted, int source, int destination){
        visted[source] = true;
        if(source==destination) return true;
        for(int nbr: adj[source]){
            if(!visted[nbr]){
                if(dfs(adj,visted,nbr,destination)) return true;
            }
        }
        return false;
    }
}