class Solution {
    public boolean isAnagram(String s, String t) {
       int n1 = t.length();
       int n2 = s.length();
       if (n1!=n2) return false;
       int[] freq = new int[26];
    //  iterating over t
       for(int i=0;i<n1;i++){
        char curr = t.charAt(i);
        freq[curr - 'a'] +=1;
       } 
    //  iterating over s
        for(int i=0;i<n2;i++){
            char curr = s.charAt(i);
            freq[curr-'a']-=1;
        }
    // check all zeros in freq
        for(int x: freq){
            if (x!=0) return false;
        }
        return true;
    }
}