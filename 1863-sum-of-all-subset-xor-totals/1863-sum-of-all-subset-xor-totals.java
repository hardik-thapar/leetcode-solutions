class Solution {
    int res = 0;
    private void dfs(int i, int[] nums, int xor){
        if(i==nums.length){
            res+=xor;
            return;
        }
        dfs(i+1, nums, xor^nums[i]);
        dfs(i+1, nums, xor);
        return;
    }
    public int subsetXORSum(int[] nums) {
        dfs(0, nums, 0);
        return res;
    }
}