class Solution {
    private int dfs(int num, int[] dp){
        if(num==0) return 0;
        if(dp[num]!=-1) return dp[num];
        int split = Integer.MIN_VALUE;
        for(int i=1; i<=num/2; i++){
            split = Math.max(split, (Math.max(i, dfs(i, dp)) * Math.max(num-i, dfs(num-i, dp))));
        }
        dp[num] = split;
        return dp[num];
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dfs(n, dp);
    }
}