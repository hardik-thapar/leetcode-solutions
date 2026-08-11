class Solution {
    private List<String> res = new ArrayList<>();
    private int num;
    private char[] words = {'a','b','c'};
    private void dfs(StringBuffer curr){
        if(curr.length()==num){
            res.add(new String(curr));
            return;
        }
        for(char ch: words){
            if(curr.toString().equals("")){
                curr.append(ch);
                dfs(curr);
                curr.deleteCharAt(curr.length()-1);
            }
            else if(curr.charAt(curr.length()-1)!=ch){
                curr.append(ch);
                dfs(curr);
                curr.deleteCharAt(curr.length()-1);
            }
        }
        return;
    }
    public String getHappyString(int n, int k) {
        if(n==0) return "";
        num = n;
        dfs(new StringBuffer(""));
        if(k>res.size()) return "";
        return res.get(k-1);
    }
}