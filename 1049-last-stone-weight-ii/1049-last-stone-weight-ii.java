class Solution {
    private int offSet;
    private int dfs(int idx, int target, int[] stones, int[][] memo){
        if(idx==stones.length){
            return target;
        }
        if(memo[idx][target+offSet]!=-1) return memo[idx][target+offSet];
        memo[idx][target+offSet] =  Math.min(Math.abs(dfs(idx+1, target-stones[idx], stones, memo)), Math.abs(dfs(idx+1, target+stones[idx], stones, memo)));
        return memo[idx][target+offSet];
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i=0; i<stones.length; i++) sum+= stones[i];
        offSet = sum;
        int[][] memo = new int[stones.length][sum*2];
        for(int i=0; i<stones.length; i++) Arrays.fill(memo[i], -1);
        return dfs(1, stones[0], stones, memo);
    }
}