class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int left = 0;
        for(int i=0; i<weights.length; i++){
            sum+= weights[i];
            left = Math.max(left, weights[i]);
        }
        int right = sum;
        
        int res = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right-left)/2;
            int d = 0;
            int belt = 0;
            for(int i=0; i<weights.length; i++){
                if(belt + weights[i] > mid){
                    belt = 0;
                    d++;
                }
                belt+=weights[i];
            }
            if(belt > 0) d++;
            if(d <= days){ 
                res = Math.min(mid, res);
                right = mid-1;
            }
            else left = mid+1;
        }
        return res;
    }
}