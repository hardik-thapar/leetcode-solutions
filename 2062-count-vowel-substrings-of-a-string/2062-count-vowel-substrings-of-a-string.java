class Solution {
    private boolean check(String word) {
        return (word.indexOf('a')>=0 && word.indexOf('e')>=0 && word.indexOf('i')>=0 && word.indexOf('o')>=0 && word.indexOf('u')>=0);
    }
    private boolean isVowel(char c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
    public int countVowelSubstrings(String word) {
        int cnt = 0;
        for(int i=0; i<word.length(); i++){
            for(int j=i; j<word.length(); j++){
                if(!isVowel(word.charAt(j))) break;
                else if(check(word.substring(i, j+1))) cnt++;
            }
        }
        return cnt;
    }
}