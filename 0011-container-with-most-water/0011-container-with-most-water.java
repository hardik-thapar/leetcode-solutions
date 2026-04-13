class Solution {
    public int maxArea(int[] height) {
        int st = 0;
        int end = height.length-1;
        int max_area = 0;
        // int area = 0;
        while(st<end){
           max_area = Math.max(max_area,((Math.min(height[st],height[end])) * (end-st)));
           if(height[st]<height[end]){
            st++;
           }
           else{
            end--;
           }
        }
        return max_area;
    }
}