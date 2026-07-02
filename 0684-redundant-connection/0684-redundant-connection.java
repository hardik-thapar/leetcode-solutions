class Solution {
    private int find(int node, int[] parent){
        if(parent[node] == node) return node;
        return find(parent[node], parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for(int i=1; i<edges.length+1; i++){
            parent[i] = i;
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int leader1 = find(u, parent);
            int leader2 = find(v, parent);
            if(leader1==leader2) return new int[]{u,v};
            else parent[leader2] = leader1;
        }
        return new int[]{-1,-1};
    }
}