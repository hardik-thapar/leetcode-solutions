class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[]  res = new ArrayList[n];
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            res[i] = new ArrayList<>();
            vis[i] = false;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            res[u].add(v);
            res[v].add(u);
        }
        return dfs(res,source,destination,vis);
    }
    boolean find = false;
    public boolean dfs(ArrayList<Integer>[] res, int source, int destination, boolean vis[]){
        if(source==destination) return true;
        
        if(!vis[source]){
            vis[source] = true;
            for(int nei: res[source]){
                if(nei == destination) return true;
                if(dfs(res,nei,destination,vis)) return true;
            }
        }
    return false;
    }

}