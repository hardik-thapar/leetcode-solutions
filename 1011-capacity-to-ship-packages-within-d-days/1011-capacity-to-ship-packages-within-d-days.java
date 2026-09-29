class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<weights.length; i++){
            sum+= weights[i];
            max = Math.max(max, weights[i]);
        }
        int left = max;
        int right = sum;
        while(left<=right){
            int mid = left + (right-left)/2;
            //we have capacity now, we try to load all packages
            //kep intial day and check
            int d = 1;
            int belt = 0;
            for(int i=0; i<weights.length; i++){
                if(belt + weights[i] > mid){
                    d++;
                    belt = 0;
                }
                belt += weights[i];
            }
            if(d <= days) {
                res = Math.min(mid, res);
                right = mid-1;
            }
            else left = mid+1;
        }
        return res;
    }
}