class Solution {
    public int[] leftRightDifference(int[] nums) {
      int[] arr = new int[nums.length];
      int pre = 0;
      for(int i=0;i<nums.length;i++){
        arr[i] = pre;
        pre+=nums[i];
      }
      pre = 0;
      for(int j=nums.length-1;j>=0;j--){
        arr[j] -= pre;
        if(arr[j]<0) arr[j]*=-1;
        pre+= nums[j];
      }  
      return arr;
    }
}