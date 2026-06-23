class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Arrays.sort(piles);
        // if(piles.length==1) return piles[0];
        int start = 1;
        int end =  Arrays.stream(piles).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        while(start<=end){
            int speed = start+(end-start)/2;
            long time = 0;
            for(int pile: piles){
                time+=(pile+speed-1L)/speed;
            }
            if(time <= h){
                ans = Math.min(ans,speed);
                end = speed-1;
            }
            else start = speed+1;

            
        }
        return ans;
    }
}