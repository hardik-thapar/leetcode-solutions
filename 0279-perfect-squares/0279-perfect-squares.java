class Solution {
    private int dfs(int num, int[] dp, List<Integer> sq){
        if(num==0) return 0;
        if(dp[num]!=-1) return dp[num];
        int min = Integer.MAX_VALUE;
        for(int i: sq){
            if(i<=num) min = Math.min(min, dfs(num-i, dp, sq));
        }
        dp[num] = 1+min;
        return dp[num];
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        List<Integer> sq = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            sq.add(i*i);
        }
        return dfs(n, dp, sq);
    }
}