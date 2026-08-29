class Solution {
    private int dfs(int i, int j, char[] w1, char[] w2, int[][] memo){
        if(i==w1.length){
            if(j==w2.length) return 1;
            return 0;
        }
        if(j==w2.length) return 1;
        if(memo[i][j]!=-1) return memo[i][j];
        int take = 0;
        if(w1[i]==w2[j]) take+= dfs(i+1, j+1, w1, w2, memo);
        take+= dfs(i+1, j, w1, w2, memo);
        return memo[i][j] = take;
    }
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()+1];
        for(int i=0; i<s.length(); i++) Arrays.fill(memo[i], -1);
        return dfs(0, 0, s.toCharArray(), t.toCharArray(), memo);
    }
}