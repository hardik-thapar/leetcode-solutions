class Solution {
    private List<String> res = new ArrayList<>();
    private void dfs(int i, char[] word){
        if(i==word.length){
            res.add(new String(word));
            return;
        }
        if(Character.isLetter(word[i])){
            char original = word[i];
            word[i] = Character.toUpperCase(word[i]);
            dfs(i+1, word);
            word[i] = Character.toLowerCase(word[i]);
            dfs(i+1, word);
            word[i] = original;
        }
        else dfs(i+1, word);
        return;
    }
    public List<String> letterCasePermutation(String s) {
        dfs(0, s.toCharArray());
        return res;
    }
}