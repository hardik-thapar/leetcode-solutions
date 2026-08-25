class Solution {

    private int dfs(int i, int j, char[] s1, char[] s2, int[][] memo){
        if(i==s1.length || j==s2.length) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        memo[i][j]=0;
        if(s1[i]==s2[j]) memo[i][j] = 1+dfs(i+1, j+1, s1, s2, memo);
        else memo[i][j] = Math.max(dfs(i+1, j, s1, s2, memo),dfs(i, j+1, s1, s2, memo));
        return memo[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++) Arrays.fill(memo[i], -1);
        return dfs(0, 0, text1.toCharArray(), text2.toCharArray(), memo);
    }
}