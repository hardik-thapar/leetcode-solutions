class Solution {
    private static final int MOD = 1_000_000_007;
    private int dfs(int digits, int low, int high, int zero, int one, int[] dp){
        if(digits > high) return 0;
        if(dp[digits]!=-1) return dp[digits];
        if(digits >= low && digits <= high) dp[digits] = 1;
        else dp[digits] = 0;
        int z = dfs(digits+zero, low, high, zero, one, dp)%MOD;
        int o = dfs(digits+one, low, high, zero, one, dp)%MOD;
        return dp[digits] = (dp[digits]+z+o)%MOD;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);
        return dfs(0, low, high, zero, one, dp)%MOD;
    }
}