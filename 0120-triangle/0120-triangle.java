class Solution {
    private int dfs(int r, int c, int[][] dp, List<List<Integer>> triangle){
        if(r==triangle.size()) return 0;
        if(dp[r][c]!=Integer.MIN_VALUE) return dp[r][c];
        dp[r][c] = 0;
        int one = 0;
        int two = 0;
        if(r+1 < triangle.size()) one = dfs(r+1, c, dp, triangle);
        if(r+1 < triangle.size() && c+1 < dp[0].length) two = dfs(r+1, c+1, dp, triangle);
        dp[r][c] = triangle.get(r).get(c) + Math.min(one, two);
        return dp[r][c];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return dfs(0, 0, dp, triangle);
    }
}