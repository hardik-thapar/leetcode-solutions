class Solution {
    private int cnt;
    private String res="";
    private int num;
    private char[] words = {'a','b','c'};
    private void dfs(StringBuffer curr){
        if(curr.length()==num){
            cnt-=1;
            if(cnt==0) res=new String(curr);
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
        if(n==0) return res;
        cnt = k;
        num = n;
        dfs(new StringBuffer(""));
        return res;
    }
}