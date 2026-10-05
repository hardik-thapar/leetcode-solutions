class Solution {
    private int dfs(int idx, int[] nums, int req, int[][] dp){
        if(idx==nums.length){
            if(req==0) return 1;
            return 0;
        }
        if(req < 0) return 0;
        if(dp[idx][req]!=0) return dp[idx][req];
        return dp[idx][req] = dfs(idx+1, nums, req - nums[idx], dp) + dfs(idx+1, nums, req, dp);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i=0; i<nums.length; i++) total+=nums[i];
        if((target+total)%2!=0 || (total+target)<0) return 0;
        int req = (total+target)/2;
        int[][] dp = new int[nums.length][req+1];
        for(int i=0; i<nums.length; i++) Arrays.fill(dp[i], 0);
        return dfs(0, nums, req, dp);
    }
}