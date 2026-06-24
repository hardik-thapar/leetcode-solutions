class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        boolean[] visted = new boolean[n];
        boolean[] path = new boolean[n];
        for(int[] arr: prerequisites){
            int u = arr[0];
            int v = arr[1];
            adj[v].add(u);
        }
        for(int i=0;i<n;i++){
            if(!visted[i]){
                if(dfs(adj,i,visted,path)) return false;
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<Integer>[] adj, int node, boolean[] visited, boolean[] path){
        visited[node] = true;
        path[node] = true;
        for(int nbr: adj[node]){
            if(path[nbr]) return true;
            else if(!visited[nbr]){
                if(dfs(adj,nbr,visited,path)) return true;
        }
        }
        path[node] = false;
        return false;
     }
}
