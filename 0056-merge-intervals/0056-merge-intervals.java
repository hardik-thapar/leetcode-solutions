class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        // for loop from 1;
        for(int i=1; i<intervals.length; i++){
            // case 1:
            if(end<intervals[i][0]) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            // case 2:
            else {
                end = Math.max(end, intervals[i][1]);  
            }

        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}