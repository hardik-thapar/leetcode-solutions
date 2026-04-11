class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int st = 0;
        int m =0;
        int l=0;
        for(int end=0;end<s.length();end++){
            char c = s.charAt(end);
            freq[c-'A'] += 1;
            if(freq[c-'A'] > m){
                m=freq[c-'A'];
            }
            while((end-st+1) - m > k){
                freq[s.charAt(st)-'A']-=1;
                st++;
            }
            l = Math.max(l,end-st+1);
        }
        return l;
    }
}