class Solution {
    int cnt = 0;
    public void dfs(ArrayList<Integer>[] adj, int node, boolean[] visited, boolean[] path){
        visited[node] = true;
        path[node] = true;
        for(int nbr: adj[node]){
            if(path[nbr]) return;
            if(!visited[nbr]) dfs(adj, nbr, visited, path);
        }
        cnt++;
        path[node] = false;
        return;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj[v].add(u);
        }
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]) dfs(adj,i,visited,path);
        }
        if(n==cnt) return true;
        return false;
    }
}