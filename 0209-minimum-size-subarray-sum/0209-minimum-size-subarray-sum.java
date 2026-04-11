class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int st = 0;
        int sum = 0;
        for (int end=0; end < nums.length; end++){
            sum+= nums[end];
            while(sum >= target){
                minLen = Math.min(minLen,end-st+1);
                sum = sum - nums[st];
                st++;
            }
        }
        if (minLen == Integer.MAX_VALUE)return 0;
        return minLen;
    }
}