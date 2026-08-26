class Solution {
    private int dfs(int i, int j, char[] s, char[] r, int[][] memo){
        if(i==s.length || j==r.length) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(s[i]==r[j]) memo[i][j] = 1+dfs(i+1, j+1, s, r, memo);
        else memo[i][j] = Math.max(dfs(i+1, j, s, r, memo), dfs(i, j+1, s, r, memo));
        return memo[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()+1];
        for(int i=0; i<s.length(); i++) Arrays.fill(memo[i], -1);
        return dfs(0,0, s.toCharArray(), new StringBuilder(s).reverse().toString().toCharArray(), memo);
    }
}