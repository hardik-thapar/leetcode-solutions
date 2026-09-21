class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] used = new int[128];
        int maxLen = 0;
        int st = 0;
        int end = 0;
        while(end<s.length() && st<=end){
            used[s.charAt(end)]++;
            while(used[s.charAt(end)]>1){
                used[s.charAt(st)]--;
                st++;
            }
            maxLen = Math.max(maxLen, end-st+1);
            end++;
        }
        return maxLen;
    }
}