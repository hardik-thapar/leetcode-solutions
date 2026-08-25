class Solution {
    private int dfs(int i, int j, char[] s, char[] t, int[][] memo){
        if(i==s.length){
            if(j==t.length) return 1;
            return 0;
        }
        if(j==t.length) return 1;
        if(memo[i][j]!=-1) return memo[i][j];
        int take = 0;
        if(s[i]==t[j]) take = dfs(i+1, j+1, s, t, memo);
        take+= dfs(i+1, j, s, t, memo);
        return memo[i][j] = take;
    }
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for(int i=0; i<s.length(); i++) Arrays.fill(memo[i], -1);
        return dfs(0, 0, s.toCharArray(), t.toCharArray(), memo);
    }
}