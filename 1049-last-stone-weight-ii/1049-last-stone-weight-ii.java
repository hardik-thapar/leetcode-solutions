class Solution {
    private int offset;
    private int dfs(int idx, int target, int[] stones, int[][] memo){
        if(idx==stones.length) return target;
        if(target<-offset || target>offset) return 0;
        if(memo[idx][target+offset]!=-1) return memo[idx][target+offset];
        memo[idx][target+offset] = Math.min(Math.abs(dfs(idx+1, target-stones[idx], stones, memo)),Math.abs(dfs(idx+1, target+stones[idx], stones, memo)));
        return memo[idx][target+offset];
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i=0; i<stones.length; i++) sum+= stones[i];
        offset = sum;
        int[][] memo = new int[stones.length][(sum*2)+1];
        for(int i=0; i<stones.length; i++) Arrays.fill(memo[i], -1);
        return dfs(1, stones[0], stones, memo);
    }
}