class Solution {
    public int find(int node, int[] parent){
        if(parent[node]==node) return node;
        return find(parent[node], parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i] = i;
        }
        for(int[] edge: edges){
            int n1 = edge[0];
            int n2 = edge[1];
            int l1 = find(n1, parent);
            int l2 = find(n2, parent);
            if(l1==l2) return new int[]{n1,n2};
            parent[l2] = parent[l1];
        }
        return new int[]{-1,-1};
    }
}