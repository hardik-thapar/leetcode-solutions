class Solution {
    List<String> res = new ArrayList<>();
    private void dfs(int i, char[] words){
        if(i==words.length){
            res.add(new String(words));
            return;
        }
        if(Character.isLetter(words[i])){
            char og = words[i];
            words[i] = Character.toUpperCase(words[i]);
            dfs(i+1, words);
            words[i] = Character.toLowerCase(words[i]);
            dfs(i+1, words);
            words[i] = og;
        }
        else dfs(i+1, words);
        return;
    }
    public List<String> letterCasePermutation(String s) {
        dfs(0, s.toCharArray());
        return res;
    }
}