class Solution {
    public int strStr(String haystack, String needle) {
        int st = 0;
        for(int end=needle.length()-1; end<haystack.length(); end++){
            if(haystack.substring(st,end+1).equals(needle)) return st;
            st++;
        }
        return -1;
    }
}