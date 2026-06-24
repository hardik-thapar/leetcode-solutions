class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int a=0;a<m;a++){
            for(int b=0;b<n;b++){
                if(mat[a][b]==0){
                    q.add(new int[]{a,b});
                }
                if(mat[a][b]==1) mat[a][b]=-1;
            }
        }
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0;x<size;x++){
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                // up
                if(i>0 && mat[i-1][j]==-1){
                    mat[i-1][j]=level;
                    q.add(new int[]{i-1,j});
                }
                // down
                if(i<m-1 && mat[i+1][j]==-1){
                    mat[i+1][j]=level;
                    q.add(new int[]{i+1,j});
                }
                // left
                if(j>0 && mat[i][j-1]==-1){
                    mat[i][j-1]=level;
                    q.add(new int[]{i,j-1});
                }
                // right
                if(j<n-1 && mat[i][j+1]==-1){
                    mat[i][j+1]=level;
                    q.add(new int[]{i,j+1});
                }
            }
            level++;
        }
        return mat;
        }
        
    }
