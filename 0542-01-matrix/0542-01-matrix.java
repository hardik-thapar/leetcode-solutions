class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length; 
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else {mat[i][j]=-1;}
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0;x<size;x++){
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                int as = mat[i][j];
                if(i>0 && mat[i-1][j]==-1){
                    mat[i-1][j]=as+1;
                    q.add(new int[]{i-1,j});
                    }
                if(i<r-1 && mat[i+1][j]==-1){
                    mat[i+1][j] = as+1;
                    q.add(new int[]{i+1,j});
                    }
                if(j>0 && mat[i][j-1]==-1){
                    mat[i][j-1] = as+1;
                    q.add(new int[]{i,j-1});
                }
                if(j<c-1 && mat[i][j+1]==-1){
                    mat[i][j+1] = as+1;
                    q.add(new int[]{i,j+1}); 
                }
            }
            // level++;
        }
        return mat;
    }
}