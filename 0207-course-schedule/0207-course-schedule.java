class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int processed = 0;
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj[v].add(u);
            indegree[u]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            processed++;
            for(int nbr: adj[node]){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }
        if(processed==n) return true;
        return false;
    }

}