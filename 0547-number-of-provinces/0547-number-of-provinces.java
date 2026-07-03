class Solution {
    private void dfs(int[][] isConnected, int node, boolean[] visited){
        visited[node] = true;
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[node][i]==1 && !visited[i]) dfs(isConnected, i, visited);
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                cnt++;
                dfs(isConnected, i, visited);
                }
        }
        return cnt;

    }
}