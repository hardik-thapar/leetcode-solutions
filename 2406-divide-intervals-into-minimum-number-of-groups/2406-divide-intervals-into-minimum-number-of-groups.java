class Solution {
    public int minGroups(int[][] intervals) {
        // maximum/minimum platforms, interva;s, tunnels and all ->
        // split: into start and end.
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int a = 0;
        int b = 0;
        int res = 0;
        while(a<start.length){
            if(start[a] <= end[b]){
                a++;
            }
            else b++;
            res = Math.max(res, a-b);
        }
        return res;
    }
}