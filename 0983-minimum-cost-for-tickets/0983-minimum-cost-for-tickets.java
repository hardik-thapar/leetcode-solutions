class Solution {
    private int dfs(int idx, int[] day, int[] dp, int[] cost){
        if(idx>=day.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        if(day[idx]==0) return dp[idx] = dfs(idx+1, day, dp, cost);
        int one = cost[0] + dfs(idx+1, day, dp, cost);
        int seven = cost[1] + dfs(idx+7, day, dp, cost);
        int thirty = cost[2] + dfs(idx+30, day, dp, cost);
        return dp[idx] = Math.min(one, Math.min(seven, thirty));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] day = new int[366];
        for(int i=0; i<days.length; i++){
            day[days[i]] = 1;
        }
        int[] dp = new int[365+1];
        Arrays.fill(dp, -1);
        return dfs(0, day, dp, costs);
    }
}