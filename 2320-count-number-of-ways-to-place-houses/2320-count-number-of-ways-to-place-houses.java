class Solution {
    private static final int MOD = 1_000_000_007;
    private long dfs(int idx, int n, long[] dp){
        if(idx>=n) return 1;
        if(dp[idx]!=-1) return dp[idx];
        long place = dfs(idx+2, n, dp);
        long dontPlace = dfs(idx+1, n, dp);
        return dp[idx] = (place + dontPlace)%MOD;
    }
    public int countHousePlacements(int n) {
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        long ways = dfs(0,n,dp);
        long res = (ways*ways)%MOD;
        return (int) res;
    }
}