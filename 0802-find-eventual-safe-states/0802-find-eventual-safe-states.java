class Solution {
    public boolean dfs(ArrayList<Integer>[] adj, int node, boolean[] visited, boolean[] path, boolean[] ans){
        visited[node] = true;
        path[node] = true;
        for(int nbr: adj[node]){
            if(path[nbr]){
                ans[node] = true;
                return true;
            }
            else {
                if(!visited[nbr]){
                if(dfs(adj,nbr,visited,path,ans)){ans[node]=true;
                return true;}}
            }   
        }
        path[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        boolean[] ans = new boolean[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
            for(int x: graph[i]){
                adj[i].add(x);
            }
        }
        for(int x=0;x<n;x++){
            if(!visited[x]) dfs(adj,x,visited,path,ans);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ans[i]==false) res.add(i);
        }
        return res;
    }
}