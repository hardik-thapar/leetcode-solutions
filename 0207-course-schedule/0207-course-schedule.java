class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses; 
        int[] indegree = new int[n];
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
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                cnt++;
                q.offer(i);}
        }

        while(!q.isEmpty()){
            int node = q.poll();
            for(int nbr: adj[node]){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    cnt++;
                    q.offer(nbr);}
            }
        }
        return (cnt==n);
    }
}