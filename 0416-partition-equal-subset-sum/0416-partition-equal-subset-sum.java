class Solution {
    private int offset;
    private Boolean dfs(int idx, int target, int[] nums, Boolean[][] memo){
        if(idx==nums.length){
            if(target==0) return true;
            return false;
        }
        if(memo[idx][target+offset]!=null) return memo[idx][target+offset];
        memo[idx][target+offset] = (dfs(idx+1, target+nums[idx], nums, memo)) || (dfs(idx+1, target-nums[idx], nums, memo));
        return memo[idx][target+offset];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+= nums[i];
        }
        if(sum%2!=0) return false;
        offset = sum;
        Boolean[][] memo = new Boolean[nums.length][(sum*2)+1];
        return dfs(0, 0, nums, memo);
    }
}