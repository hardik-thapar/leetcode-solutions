class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
            vis[i] = false;
        }
        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                if((isConnected[i][j] == 1) && i!=j){
                    graph[i].add(j);
                }
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(i,graph,vis);
                count++;
            }
        }
        return count;
    }
    public void dfs(int start,ArrayList<Integer>[] graph, boolean[] vis){
        if(vis[start]==false){
            vis[start] = true;
            for(int nei: graph[start]){
                dfs(nei,graph,vis);
            }
        }
    }
}