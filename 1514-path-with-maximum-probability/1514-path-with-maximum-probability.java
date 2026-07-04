class Solution {
    static class Pair {
            int node;
            double value;
            Pair(int node, double value){
                this.node = node;
                this.value = value;
            }
        }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Pair>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double weight = succProb[i];
            adj[u].add(new Pair(v,weight));
            adj[v].add(new Pair(u,weight));
        }
        // Pair -> {node, dist}
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.value,a.value));

        double[] prob = new double[n];
        Arrays.fill(prob, Double.MIN_VALUE);
        prob[start_node] = 1;
        pq.offer(new Pair(start_node,prob[start_node]));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.value < prob[curr.node]) continue;
            for(Pair nbr: adj[curr.node]){
                if(curr.value * nbr.value > prob[nbr.node]){
                    prob[nbr.node] = curr.value * nbr.value;
                    pq.offer(new Pair(nbr.node, prob[nbr.node]));
                }
            }
        }
        if(prob[end_node]==Double.MIN_VALUE) return 0;
        return prob[end_node];
    }
}