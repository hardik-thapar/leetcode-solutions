class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l = 0;
        int r = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder ans = new StringBuilder();

        while(l<n1 && r<n2){
            ans.append(word1.charAt(l));
            ans.append(word2.charAt(r));
            l++;
            r++;
        }
        while(l<n1){
            ans.append(word1.charAt(l));
            l++;
        }
        while(r<n2){
            ans.append(word2.charAt(r));
            r++;
        }
        return ans.toString();

    }
}