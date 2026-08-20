class Solution {
    private int cnt = 0;
    private int dfs(int i, String s, int[] dp){
        if(i>s.length()-1){
           return 1;
        }

        if(dp[i]!=-1) return dp[i];
        dp[i] = 0;
        if(i <= s.length()-1){
            int one = s.charAt(i) - '0'; 
            if(one >= 1 && one <= 9) dp[i] += dfs(i+1, s, dp);
        }
        if(i+1 <= s.length()-1){ 
            int two = (s.charAt(i) - '0' )*10 + s.charAt(i+1)-'0';
            if(two >= 10 && two <= 26) dp[i] += dfs(i+2, s, dp);
        }
        return dp[i];
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return dfs(0, s, dp);
    }
}