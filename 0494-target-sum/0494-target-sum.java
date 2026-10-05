class Solution {
    private int res = 0;
    private void dfs(int idx, int[] nums, int sum, int target){
        if(idx==nums.length){
            if(sum==target) res++;
            return;
        }
        dfs(idx+1, nums, sum+nums[idx], target);
        dfs(idx+1, nums, sum-nums[idx], target);
        return;
    }
    public int findTargetSumWays(int[] nums, int target) {
        dfs(0, nums, 0, target);
        return res;
    }
}