class Solution {
    private List<String> res = new ArrayList<>();
    private char toogle(char x){
        if(Character.isUpperCase(x)) return Character.toLowerCase(x);
        return Character.toUpperCase(x);
    }
    private void dfs(int i, char[] word, StringBuffer curr){
        if(i==word.length){
            res.add(new String(curr));
            return;
        }
        
        if(Character.isLetter(word[i])){
            char t = toogle(word[i]);
            curr.append(word[i]);
            dfs(i+1, word, curr);
            curr.deleteCharAt(curr.length()-1);
            curr.append(t);
            dfs(i+1, word, curr);
            curr.deleteCharAt(curr.length()-1);
        }
        else {dfs(i+1, word, curr.append(word[i]));
        curr.deleteCharAt(curr.length()-1);}
        return;
    }
    public List<String> letterCasePermutation(String s) {
        dfs(0, s.toCharArray(), new StringBuffer(""));
        return res;
    }
}