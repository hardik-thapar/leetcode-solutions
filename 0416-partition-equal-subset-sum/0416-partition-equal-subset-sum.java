class Solution {
    private boolean dfs(int idx, int sum, int[] nums, Boolean[][] memo){
        if(sum==0) return true;
        if(sum <= 0) return false;
        if(idx>nums.length-1) return false;
        if(memo[idx][sum]!=null) return memo[idx][sum];
        memo[idx][sum] = dfs(idx+1, sum-nums[idx], nums, memo) || dfs(idx+1, sum, nums, memo);
        return memo[idx][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum%2==1) return false;
        Boolean[][] memo = new Boolean[nums.length+1][(sum/2)+1];
        return dfs(0, sum/2, nums, memo);
    }
}