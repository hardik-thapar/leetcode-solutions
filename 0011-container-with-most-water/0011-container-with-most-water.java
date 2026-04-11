class Solution {
    public int maxArea(int[] height) {
        int st = 0;
        int end = height.length - 1;
        int area = 0;
        // int left=0;
        // int right=0;
        while(st<end){
            int a = Math.min(height[st],height[end])*(end-st);
            if(height[st]<height[end]){
                st++;
            }
            else{
                end--;
            }
            area = Math.max(a,area);

        }
        return area;
    }
}