class Solution {
    private int n;
    private String word;
    private int res = 0;
    private Set<String> set = new HashSet<>();
    private void dfs(int i){
        if(i==n){
            res = Math.max(res, set.size());
            return;
        }
        for(int j=i; j<n; j++){
            String curr = word.substring(i,j+1);
            if(!set.contains(curr)){
            set.add(curr);
            dfs(j+1);
            set.remove(curr); }
        }
        return;
    }
    public int maxUniqueSplit(String s) {
        n = s.length();
        word = new String(s);
        dfs(0);
        return res;
    }
}