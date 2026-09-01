class Solution {
    private int dfs(int left, int right, int[] boundary, int[][] memo){
        if(left>=right) return 0;
        if(right-left <= 1) return 0;
        if(memo[left][right]!=-1) return memo[left][right];
        int res = Integer.MAX_VALUE;
        for(int i=left+1; i<right; i++){
            res = Math.min(res, dfs(left, i, boundary, memo) + dfs(i, right, boundary, memo) + boundary[right] - boundary[left]);
        }
        return memo[left][right] = res;
    }
    public int minCost(int n, int[] cuts) {
        int[] boundary = new int[cuts.length + 2];
        boundary[0] = 0;
        boundary[boundary.length-1] = n;
        for(int i=1; i<boundary.length-1; i++) boundary[i] = cuts[i-1];
        Arrays.sort(boundary);
        int[][] memo = new int[boundary.length][boundary.length];
        for(int i=0; i<memo.length; i++) Arrays.fill(memo[i], -1);
        return dfs(0, boundary.length-1, boundary, memo);
    }
}