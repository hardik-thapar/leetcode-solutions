class Solution {
    private static final int[][] grid = {
        {4,6},
        {6,8},
        {7,9},
        {4,8},
        {0,3,9},
        {},
        {0,1,7},
        {2,6},
        {1,3},
        {2,4}
    };
    private static final int MOD = 1_000_000_007;
    private long dfs(int digit, int n, long[][] dp){
        if(n==0) return 1;
        if(dp[digit][n]!=-1) return dp[digit][n];
        dp[digit][n] = 0;
        for(int nbr: grid[digit]){
            dp[digit][n] += dfs(nbr, n-1, dp);
        }
        return (dp[digit][n])%MOD;
    }
    public int knightDialer(int n) {
        long[][] dp = new long[10][n+1];
        for(int i=0; i<10; i++) Arrays.fill(dp[i], -1);
        long res = 0;
        for(int i=0; i<10; i++){
            res += dfs(i, n-1, dp);
        }
        res = res%MOD;
        return (int) res;
    }
}