class Solution {
    private int cnt = 0;

    private int dfs(int idx, String s, int[] dp){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx]!=-1) return dp[idx]+1;
        if(idx+1 <= s.length()){
            int one = s.charAt(idx) - '0';
            if(one>=1 && one<=9) dp[idx]+= dfs(idx+1, s, dp);
        }
        if(idx+1 < s.length()){
            int two = (s.charAt(idx) - '0')*10 + s.charAt(idx+1)-'0';
            if(two>=10 && two<=26) dp[idx]+= dfs(idx+2, s, dp);
        }
        return dp[idx]+1;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(0, s, dp);

    }
}