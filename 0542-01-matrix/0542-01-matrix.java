class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else mat[i][j] = -1;}}
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0;x<size;x++){
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];
                int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
                for(int[] d: dir){
                    int nr = i+d[0];
                    int nc = j+d[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                        mat[nr][nc] = level;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            level++;
        }
        return mat;
    }
}