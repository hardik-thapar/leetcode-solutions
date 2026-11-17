class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] freq;
    private int dfs(int idx, int col, String[] words, String target, int[][] dp, int[][] freq){
        if(idx==target.length()) return 1;
        if(col==words[0].length()) return 0;
        if(dp[idx][col]!=-1) return dp[idx][col]%MOD;
        long pick  = ((long) freq[col][target.charAt(idx)-'a']*(dfs(idx+1, col+1, words, target, dp, freq)%MOD))%MOD;
        long skip  = dfs(idx, col+1, words, target, dp, freq)%MOD;
        return dp[idx][col] = (int) ((pick+skip)%MOD);

    }
    public int numWays(String[] words, String target) {
        this.freq = new int[words[0].length()][26];
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[0].length(); j++){
                int c = words[i].charAt(j)-'a';
                freq[j][c]++;
            }
        }
        int[][] dp = new int[target.length()][words[0].length()];
        for(int i=0; i<target.length(); i++) Arrays.fill(dp[i], -1);
        return dfs(0, 0, words, target, dp, freq)%MOD;
    }
}