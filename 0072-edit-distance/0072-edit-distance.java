class Solution {
    private int dfs(int i, int j, char[] s1, char[] s2, int[][] memo){
        if(i==s1.length && j==s2.length) return 0;
        if(i==s1.length) return s2.length - j;
        if(j==s2.length) return s1.length - i;
        if(memo[i][j]!=-1) return memo[i][j];
        // ways ->
        // if equal-> then i+1,j+1
        // if we replace-> 1 + i+1,j+1
        // if insert -> 1 + i,j+1
        // if delete-> 1+ i+1, j
        if(s1[i]==s2[j]) memo[i][j] = dfs(i+1, j+1, s1, s2, memo);
        else memo[i][j] = Math.min(Math.min(1+dfs(i+1,j+1, s1, s2, memo), 1+dfs(i+1,j, s1, s2, memo)), 1+dfs(i,j+1, s1, s2, memo));
        return memo[i][j];
    }
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()+1];
        for(int i=0; i<word1.length(); i++) Arrays.fill(memo[i], -1);
        return dfs(0, 0, word1.toCharArray(), word2.toCharArray(), memo);
    }
}