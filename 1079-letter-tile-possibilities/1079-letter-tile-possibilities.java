class Solution {
    int[] freq = new int[26];
    int cnt = 0;
    private void dfs(){
        for(int i=0; i<26; i++){
            if(freq[i]>0){
                cnt++;
                freq[i]-=1;
                dfs();
                freq[i]+=1;
            }
        }
        return;
    }

    public int numTilePossibilities(String tiles) {
        for(char x: tiles.toCharArray()){
            freq[x-'A']++;
        }
        dfs();
        return cnt;
    }
}