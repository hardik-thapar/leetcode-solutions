class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int st=0;
        int res = 0;
        for(int end = 0; end<s.length();end++){
            char x = s.charAt(end);
            while(set.contains(x)){
                set.remove(s.charAt(st));
                st++;
            }
            set.add(x);
            res = Math.max(res,end-st+1);

        }
        return res;
    }
}