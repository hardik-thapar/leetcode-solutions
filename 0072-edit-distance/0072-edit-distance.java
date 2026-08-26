class Solution {
    private int dfs(int i, int j, char[] w1, char[] w2, int[][] memo){
        if(i==w1.length && j==w2.length) return 0;
        if(i==w1.length) return w2.length - j;
        if(j==w2.length) return w1.length - i;
        if(memo[i][j]!=-1) return memo[i][j];
        /* 
        if(equal) -> dfs(i+1, j+1)
        replace -> 1 + dfs(i+1, j+1)
        insert -> 1 + dfs(i, j+1)
        deleting -> 1 + dfs(i+1, j)
        */
        if(w1[i]==w2[j]) memo[i][j] = dfs(i+1, j+1, w1, w2, memo);
        else {
            int replace = 1+dfs(i+1, j+1, w1, w2, memo);
            int insert = 1+dfs(i, j+1, w1, w2, memo);
            int delete = 1+dfs(i+1, j, w1, w2, memo);
            memo[i][j] = Math.min(Math.min(insert, delete), replace);
        }
        return memo[i][j];
    }
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()+1];
        for(int i=0; i<word1.length(); i++) Arrays.fill(memo[i], -1);
        return dfs(0, 0, word1.toCharArray(), word2.toCharArray(), memo);
    }
}