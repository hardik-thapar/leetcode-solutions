class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] arr: prerequisites){
            int u = arr[0];
            int v = arr[1];
            adj[v].add(u);
        }
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(adj, visited, path, i)) return false;
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<Integer>[] adj, boolean[] visited,boolean[] path, int node){
        visited[node] = true;
        path[node] = true;
        for(int nbr: adj[node]){
            if(path[nbr]) return true;
            else if(!visited[nbr]){
                if(dfs(adj,visited,path,nbr)) return true;
            }
        }
        path[node] = false;
        return false;
    }
}