class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        q.add(new int[]{0,0});
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0;x<size;x++){
            int arr[] = q.poll();
            int i= arr[0];
            int j = arr[1];
            
            if(i==n-1 && j==n-1) return level;
            
            if(i>0 && grid[i-1][j]==0){
                grid[i-1][j]=-1;
                q.add(new int[]{i-1,j});}
            if(i>0 && j>0 && grid[i-1][j-1]==0){
                grid[i-1][j-1]=-1;
                q.add(new int[]{i-1,j-1});}
            if(i>0 && j<n-1 && grid[i-1][j+1]==0){
                grid[i-1][j+1]=-1;
                q.add(new int[]{i-1,j+1});}
            if(j>0 && grid[i][j-1]==0){
                grid[i][j-1]=-1;
                q.add(new int[]{i,j-1});}
            if(j<n-1 && grid[i][j+1]==0){
                grid[i][j+1]=-1;
                q.add(new int[]{i,j+1});}
            if(i<n-1 && grid[i+1][j]==0){
                grid[i+1][j]=-1;
                q.add(new int[]{i+1,j});}
            if(i<n-1 && j<n-1 && grid[i+1][j+1]==0){
                grid[i+1][j+1]=-1;
                q.add(new int[]{i+1,j+1});}
            if(i<n-1 && j>0 && grid[i+1][j-1]==0){
                grid[i+1][j-1]=-1;
                q.add(new int[]{i+1,j-1});}
        }
        level++;
        }
        return -1;
    }
}