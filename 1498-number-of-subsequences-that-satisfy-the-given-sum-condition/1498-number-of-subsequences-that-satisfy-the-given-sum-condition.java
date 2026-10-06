class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int st = 0;
        int end = nums.length-1;
        int res = 0;
        int[] power = new int[nums.length];
        int mod = (int) 1e9 + 7;
        power[0]=1;
        for(int i=1; i<nums.length; i++){
            power[i] = (power[i-1]*2)%mod;
        }
        
        while(st<=end){
            if(nums[st] + nums[end] <= target){ 
                res = (res+power[end-st])%mod;
                st++;
                }
            else end--;

        }
        return res%mod;


    }
}