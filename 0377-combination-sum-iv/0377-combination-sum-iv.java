class Solution {
    private int dfs(int target, int[] nums, int[] memo){
        if(target==0) return 1;
        if(target<0) return 0;
        if(memo[target]!=-1) return memo[target];
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=target) res+= dfs(target-nums[i], nums, memo);
        }
        memo[target] = res;
        return memo[target];
    }
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[1001];
        Arrays.fill(memo, -1);
        return dfs(target, nums, memo);
    }
}