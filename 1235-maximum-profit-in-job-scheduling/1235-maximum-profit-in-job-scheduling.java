class Solution {
    class Job {
        int start;
        int end;
        int money;
        Job(int start, int end, int money){
            this.start = start;
            this.end = end;
            this.money = money;
        }
    }
    private int dfs(int idx, int[][] jobs, int[] dp){
        if(idx==jobs.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        // either skip at each idx, check if we can pcik -> then we have keep the history(for dp dont carry history; use it)
        // pick it
        // if picking the. skip to next possible elemnt
        int next = jobs.length; // set next default to last idx
        int end = jobs[idx][2];
        for(int i=idx; i<jobs.length; i++) {
            if(jobs[i][0] >= jobs[idx][1]){
                next = i;
                break;
            }
        }
        int pick = jobs[idx][2] + dfs(next, jobs, dp);
        int skip = dfs(idx+1, jobs, dp);
        return dp[idx] = Math.max(pick, skip);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for(int i=0; i<startTime.length; i++){
            // 0-> start, 1-> end, 2-> profit
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a,b)->Integer.compare(a[0], b[0]));
        int[] dp = new int[startTime.length+1];
        Arrays.fill(dp, -1);
        return dfs(0, jobs, dp);
    }
}