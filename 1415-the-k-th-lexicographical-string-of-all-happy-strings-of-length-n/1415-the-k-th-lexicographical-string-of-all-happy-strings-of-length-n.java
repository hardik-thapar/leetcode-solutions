class Solution {
    private char[] options = {'a','b','c'};
    private int N;
    private int K;
    private String res = "";
    private void dfs(StringBuilder curr){
        if(curr.length()==N){
            K--;
            if(K==0) res = new String(curr);
            return;
        }
        if(curr.toString().equals("")){
            for(int i=0; i<3; i++){
                curr.append(options[i]);
                dfs(curr);
                curr.deleteCharAt(curr.length()-1);
            }
            
        }
        
        else {
            char ch = curr.charAt(curr.length()-1);
            for(int i=0; i<3; i++){
                if(options[i]!=ch){
                    curr.append(options[i]);
                    dfs(curr);
                    curr.deleteCharAt(curr.length()-1);
                }
            }
        }
        return;
    }

    public String getHappyString(int n, int k) {
        if(n==0) return res;
        K=k;
        N=n;
        dfs(new StringBuilder(""));
        return res;
    }
}