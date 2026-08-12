class Solution {
    private List<String> res = new ArrayList<>();
    private String word;
    private int n;
    private String temp;
    private boolean isValid(String s){
        if(s.startsWith("0") && s.length()>1) return false;
        int num = Integer.parseInt(s);
        if(num>255 || num<0) return false;
        return true;
    }

    private void dfs(int i, StringBuilder curr, int part){
        if(part==4 && i<n) return;
        if(i==n && part==4){
            res.add(new String(curr));
            return;
        }
        for(int j=i; j<i+3; j++){
            if(j<n){
                int len = curr.length();
                temp = new String(word.substring(i, j+1));
                curr.append(word.substring(i, j+1));
                if(part<3) curr.append('.');
                if(isValid(temp)) dfs(j+1, curr, part+1);
                curr.setLength(len);
            }
        }
        return;
    }
    public List<String> restoreIpAddresses(String s) {
        word = new String(s);
        n = s.length();
        if(s.length()>12) return res;
        dfs(0, new StringBuilder(""), 0);
        return res;
    }
}