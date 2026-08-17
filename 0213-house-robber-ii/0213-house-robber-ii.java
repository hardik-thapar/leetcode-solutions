class Solution {
    private int dfs(int idx, int stop, int[] dp, int[] nums){
        if(idx>=stop) return 0;
        if(dp[idx]!=-1) return dp[idx];
        dp[idx] = Math.max(nums[idx] + dfs(idx+2, stop, dp, nums), dfs(idx+1, stop, dp, nums));
        return dp[idx];
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int res = dfs(0, nums.length-1, dp, nums);
        Arrays.fill(dp, -1);
        res = Math.max(res, dfs(1, nums.length, dp, nums));
        return res;
    }
}