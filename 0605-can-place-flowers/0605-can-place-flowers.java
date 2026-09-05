class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for(int i=0; i<flowerbed.length; i++){
            boolean left = false;
            if(i==0) left = true;
            else if(flowerbed[i-1]==0) left = true;
            boolean right = false;
            if(i==flowerbed.length-1) right = true;
            else if(flowerbed[i+1]==0) right = true;
            if(left && right && flowerbed[i]==0){
                res++;
                flowerbed[i]=1;
            }
        }
        if(res>=n) return true;
        return false;
    }
}