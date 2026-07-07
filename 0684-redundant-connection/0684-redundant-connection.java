class Solution {
    private int find(int node, int[] parent){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node],parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for(int i=1; i<edges.length+1; i++){
            parent[i] = i;
        }
        int[] res = {};
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int leader_u = find(u, parent);
            int leader_v = find(v, parent);
            if(leader_u == leader_v) res = new int[]{u,v};
            else parent[leader_v] = leader_u;
        }
        return res;
    }
}