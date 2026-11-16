class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals, (a,b)->{
        if(a[1]==b[1]) return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]);
       });
       int end = Integer.MIN_VALUE;
       int cnt = 0;
       for(int i=0; i<intervals.length; i++){
        if(intervals[i][0] < end){
            cnt++;
            continue;
        }
        end = intervals[i][1];
       }
        return cnt;
    }
}