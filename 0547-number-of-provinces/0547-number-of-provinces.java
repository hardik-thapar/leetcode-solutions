class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj[i].add(j);
                }
            }
        }
        boolean[] visted = new boolean[n];
        for(int i=0; i<n;i++){
            if(!visted[i]){
                provinces++;
                dfs(adj, i, visted);
            }
        }
        return provinces;
    }

        void dfs(ArrayList<Integer>[] adj, int i, boolean[] visted){
           if(visted[i]) return;
           visted[i] = true;
           for(int nbr: adj[i]){
            dfs(adj,nbr,visted);
           }
           return;
        }
    }
