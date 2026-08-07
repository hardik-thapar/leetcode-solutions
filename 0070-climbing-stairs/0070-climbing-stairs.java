class Solution {
    private int dfs(int n, int[] steps){
        if(n<=1) return 1;
        if(steps[n]!=-1) return steps[n];
        steps[n] = dfs(n-1, steps) + dfs(n-2, steps);
        return steps[n];
    }
    public int climbStairs(int n) {
        int[] steps = new int[n+1];
        Arrays.fill(steps,-1);
        return dfs(n, steps);
    }
}