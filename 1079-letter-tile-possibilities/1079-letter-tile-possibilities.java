class Solution {
    private int[] freq = new int[26];
    // private List<String> res = new ArrayList<>();
    int cnt=0;
    private void dfs(){
        for(int i=0; i<26; i++){
            if(freq[i]>0){
                freq[i]-=1;
                cnt++;
                dfs();
                freq[i]+=1;
            }
        }
        return;
    }
    public int numTilePossibilities(String tiles) {
        for(char c: tiles.toCharArray()){
            freq[c-'A']++;
        }
        dfs();
        return cnt;
    }
}