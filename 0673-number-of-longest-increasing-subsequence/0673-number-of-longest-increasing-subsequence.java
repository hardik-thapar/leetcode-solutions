class Solution {

    public int findNumberOfLIS(int[] nums) {
        int temp = -1;
        int idx = -1;
        int[] dp = new int[nums.length];
        int[] ways = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(ways, 1);
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                if(dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    ways[i] = ways[j];
                }
                else if(dp[j]+1==dp[i]) ways[i] += ways[j];
            }}
            temp = Math.max(temp, dp[i]);
        }
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(dp[i]==temp) res += ways[i];
        }
        return res;
    }
}