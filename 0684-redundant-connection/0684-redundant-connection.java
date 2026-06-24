class Solution {
    public int find(int[] parent, int node){
        if(parent[node]==node) return node;
        return find(parent,parent[node]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        int[] res = new int[2];
        int[] parent = new int[n];
        for(int i=1;i<n;i++){
            parent[i] = i;
        }
        for(int[] arr: edges){
            int i1 = arr[0];
            int i2 = arr[1];
            int l1 = find(parent,i1);
            int l2 = find(parent,i2);
            if(l1==l2){
                res[0] = i1;
                res[1] = i2;
            }
            else{
                parent[l2] = parent[l1];
            }
        }
        return res;
    }
}