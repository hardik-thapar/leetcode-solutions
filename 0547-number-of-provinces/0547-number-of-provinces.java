class Solution {

    private int find(int node, int[] parent){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node], parent);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<int[]> edges = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && isConnected[i][j]==1) edges.add(new int[]{i,j});
            }
        }
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int leader1 = find(u, parent);
            int leader2 = find(v, parent);
            parent[leader2] = leader1;
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) cnt++;
        }
        return cnt;
    }
}