class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // creating the adj list
        List<int[]>[] adj = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u].add(new int[]{v,w});
        }

        // create dist arr
        int[] dist = new int[n+1];
        for(int i=1; i<n+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;

        // create pq
        // (dist,node)

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int distance = curr[0];
            int node = curr[1];
            if(distance > dist[node]) continue;
            for(int[] nbr: adj[node]){
                int nbr_node = nbr[0];
                int weight = nbr[1];
                if(distance+weight < dist[nbr_node]){
                    dist[nbr_node] = distance+weight;
                    pq.offer(new int[]{dist[nbr_node],nbr_node});
                }
            }
        }
        int max = 0;
        for(int i=1; i<n+1; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1; 
            else max = Math.max(max,dist[i]);
        }

        return max;


    }
}