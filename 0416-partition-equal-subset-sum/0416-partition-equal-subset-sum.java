class Solution {
    // if we assume target as sum/2 -> and find any subset that sums to that then it means we can partition it
    private Boolean dfs(int idx, int target, int[] nums, Boolean[][] memo){
        if(idx==nums.length){
            if(target==0) return true;
            return false;
        }
        if(target==0) return true;
        if(target<0) return false;
        if(memo[idx][target]!=null) return memo[idx][target];
        memo[idx][target] = (dfs(idx+1, target-nums[idx], nums, memo)) || (dfs(idx+1, target, nums, memo));
        return memo[idx][target];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) sum+=nums[i];
        if(sum%2==1) return false;
        Boolean[][] memo = new Boolean[nums.length][(sum/2)+1];
        return dfs(0, sum/2, nums, memo);
    }
}