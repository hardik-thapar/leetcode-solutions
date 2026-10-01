class Solution {
    public int shipWithinDays(int[] weights, int days) {
     //we use binary search similar to koko eating bananas, like run search from ax weight a day to the total sum, keep that as range then if the capacity at mid satisfied the max days then reduce interval towards left, if not then we incrase the weight capacity.
    int sum = 0;
    int left = 0;
    int res = Integer.MAX_VALUE;
    for(int i=0; i<weights.length; i++){
        sum += weights[i];
        left = Math.max(left, weights[i]);
    }
    int right = sum;
    while(left <= right){
        int mid = left + (right-left)/2;
        int d = 0;
        int cap = 0;
        for(int i=0; i<weights.length; i++){
            if(cap + weights[i] > mid){
                d++;
                cap = 0;
            }
            cap+= weights[i];
        }
        if(cap>0) d++;
        if(d<=days){
            res = Math.min(res, mid);
            right = mid-1;
        }
        else left=mid+1;
    }
    return res;
    }
}