class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // topo order: we jse indegree concept, we first create adj list and also an int[] idegree arr. then as we have an directed edge from u-v, then that means if we are at v we can move to u, means indegree[u]++, and adj[v].add(u), then we have a queue, all nodes having indegree = 0, we push to queue, then run a while loop and pop node as curr, for all nbr's of curr -> reduce indegree by 1, then check if indegree became zero then u can add it to queue, also befroe checking nbrs, add it to a arr as res. if at end any element in res arr is not reachable then return empty arr.
        int n = numCourses;
        int[] indegree = new int[n];
        int[] res = new int[n];
        
        int idx = 0;
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj[v].add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            res[idx++] = curr;
            for(int nbr: adj[curr]){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.offer(nbr);
            }
        }

        if(idx==numCourses) return res;
        return new int[]{};

    }
}