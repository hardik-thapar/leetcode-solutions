class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0;
        for(int i=0; i<k+1; i++){
            int[] temp = cost.clone();
            for(int[] edge: flights){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if(cost[u]!=Integer.MAX_VALUE && cost[u]+w < temp[v]){
                    temp[v] = cost[u]+w;
                }
            }
            cost = temp; //we re init the cost to update it 
        }

        if(cost[dst]==Integer.MAX_VALUE) return -1;
        return cost[dst];
    }
}