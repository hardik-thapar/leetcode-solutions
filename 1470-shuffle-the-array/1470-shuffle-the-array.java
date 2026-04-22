class Solution {
    public int[] shuffle(int[] nums, int n) {
       int first = 0;
       int second = n;
       int[] arr = new int[2*n];
       int i=0;
       while(first<second && second<2*n){
        arr[i] = nums[first];
        first++;
        arr[i+1] = nums[second];
        second++;
        i=i+2;
       }
       return arr;
    }
}