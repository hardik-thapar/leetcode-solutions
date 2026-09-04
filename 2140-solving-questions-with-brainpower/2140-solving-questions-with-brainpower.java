class Solution {
    private long dfs(int idx, int[][] questions, long[] dp){
        if(idx>=questions.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        // if take
        long take = questions[idx][0] + dfs(idx+questions[idx][1]+1, questions, dp);
        long skip = dfs(idx+1, questions, dp);
        return dp[idx] = Math.max(take, skip);
    }
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        Arrays.fill(dp, -1);
        return dfs(0, questions, dp);
    }
}