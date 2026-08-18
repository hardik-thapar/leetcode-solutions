class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private int helper(int pos, int[] stones){
        // if(pos >= stones.length) return -1;
        if(map.containsKey(pos)) return map.get(pos);
        return -1;
    }
    private boolean dfs(int idx, int k,Boolean[][] memo, int[] stones){
        // k-> jumps, idx-> index, memo-> dp arr
        if(stones[idx]==stones[stones.length-1]) return true;
        int pos = stones[idx];
        if(memo[idx][k]!=null) return memo[idx][k];
        boolean check = false;
        if(k>1 && helper(pos+k-1, stones)!=-1) check = check || dfs(map.get(pos+k-1), k-1, memo, stones);
    
        if(k>0 && helper(pos+k, stones)!=-1) check = check || dfs(map.get(pos+k), k, memo, stones);

        if(helper(pos+k+1, stones)!=-1) check = check || dfs(map.get(pos+k+1), k+1, memo, stones);

        memo[idx][k] = check;
        return memo[idx][k];

    }
    public boolean canCross(int[] stones) {
       if(stones[1]!=1) return false;
       for(int i=0; i<stones.length; i++){
        map.put(stones[i], i);
       } 
       Boolean[][] memo = new Boolean[stones.length+1][stones.length+1];
       return dfs(0, 0, memo, stones);
    }
}