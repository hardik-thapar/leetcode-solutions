class Solution {
    public int minGroups(int[][] intervals) {
        // keep 2 arr, start and ends,
        // sort them, use 2 pointer si and j, if start[i] >= end[j] -> i++; else j--;
        // and after doing this at every step u check res as max of res, i - j

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int res = 0;
        while(i<=start.length-1){
            if(start[i] <= end[j]) i++;
            else j++;
            res = Math.max(res, i - j);
        }
        return res;
    }
}