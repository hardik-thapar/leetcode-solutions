class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int[] preSum = new int[101];
        int tf = 0;
        for(int i=0; i<=100; i++){
            
            preSum[i] = tf; 
            tf += freq[i];  
        }
        for(int x = 0; x<nums.length; x++){
            nums[x] = preSum[nums[x]];
        }

        return nums;
    }
}