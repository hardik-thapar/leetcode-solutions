class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int ind = 0;
        int n = 0;
        List<Integer>[] adj = new ArrayList[numCourses+1];
        int[] indegree = new int[numCourses+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            adj[v].add(u);
        }

        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            res[ind++] = node;
            n++;
            for(int nbr: adj[node]){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);}
            }
        }
        if(n==numCourses) return res;
        return new int[]{};
    }
}