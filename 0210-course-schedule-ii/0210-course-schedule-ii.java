class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] indegree = new int[n];
        int[] res = new int[n];
        int idx = 0;
        List<Integer>[] adj = new ArrayList[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj[v].add(u);
            indegree[u]++;
        }
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            res[idx++] = node;
            for(int nbr: adj[node]){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.offer(nbr);
            }
        }

        if(idx==n) return res;
        return new int[0];


    }
}