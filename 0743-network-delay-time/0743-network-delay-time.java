class Solution {
    class Pair {
        int node;
        int value;
        Pair(int node, int value){
            this.node = node;
            this.value = value;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Pair>[] adj = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            adj[u].add(new Pair(v,time));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        // Priority queue -> {dist, node}
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.value,b.value));
        dist[k] = 0;
        pq.offer(new Pair(k,dist[k]));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.value > dist[curr.node]) continue;
            for(Pair nbr: adj[curr.node]){
                if(curr.value+nbr.value < dist[nbr.node]){
                    dist[nbr.node] = curr.value + nbr.value;
                    pq.offer(new Pair(nbr.node, dist[nbr.node]));
                }
            }
        }
        int res = 0;
        for(int i=1; i<n+1; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            else res = Math.max(res, dist[i]);
        }
        return res;
    }
}