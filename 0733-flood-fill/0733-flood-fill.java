class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og = image[sr][sc];
        dfs(image, sr, sc, color, og);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int color, int og){
        if(image[sr][sc]==color) return;
        image[sr][sc] = color;
        if(sr>0 && image[sr-1][sc]==og) dfs(image, sr-1, sc, color, og);
        if(sr<image.length-1 && image[sr+1][sc]==og) dfs(image, sr+1, sc, color, og);
        if(sc>0 && image[sr][sc-1]==og) dfs(image, sr, sc-1, color, og);
        if(sc<image[0].length-1 && image[sr][sc+1]==og) dfs(image, sr, sc+1, color, og);
        return;
    }
}