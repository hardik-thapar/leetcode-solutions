class Solution {
    private boolean isPalindrome(String s){
        if(s.equals(new StringBuilder(s).reverse().toString())) return true;
        return false;
    }
    private String word;
    private int n;
    private List<List<String>> res = new ArrayList<>();
    private void dfs(int i, List<String> curr){
        if(i==n){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int j=i; j<n; j++){
            String temp = word.substring(i, j+1);
            if(isPalindrome(temp)){
                curr.add(new String(temp));
                dfs(j+1, curr);
                curr.remove(curr.size()-1);
            } 
        }
        return;
    }
    public List<List<String>> partition(String s) {
        word = new String(s);
        n = s.length();
        dfs(0, new ArrayList<>());
        return res;
    }
}