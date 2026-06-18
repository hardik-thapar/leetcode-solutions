class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        if(sr>r || sc>c) return image;
        int og = image[sr][sc];
        return dfs(image,sr,sc,color,og);
    }
    public int[][] dfs(int[][] image, int sr, int sc, int color, int og){
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == og){
        if(image[sr][sc]!=color){
            image[sr][sc] = color;
            dfs(image,sr-1,sc,color,og);
            dfs(image,sr+1,sc,color,og);
            dfs(image,sr,sc-1,color,og);
            dfs(image,sr,sc+1,color,og);
        }}
        return image;
    }
}