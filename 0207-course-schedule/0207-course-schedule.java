class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses+1];
        for(int i=0;i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses+1];
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            adj[v].add(u);
        }
        int n = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0){
                n++;
                q.add(i);}
        }

        while(!q.isEmpty()){
            int node = q.poll();
            for(int nbr: adj[node]){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    n++;
                    q.add(nbr);}
            }
        }
        return (n==numCourses);
    }
}