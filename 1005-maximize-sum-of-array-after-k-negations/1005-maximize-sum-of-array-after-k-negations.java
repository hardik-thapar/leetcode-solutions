class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) sum+= nums[i];
        for(int i=0; i<k; i++){
            Arrays.sort(nums);
            nums[0] = nums[0] - 2*nums[0];
            sum += 2*nums[0];
        }
        return sum;
    }
}