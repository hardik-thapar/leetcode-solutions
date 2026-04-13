class Solution {
    public int characterReplacement(String s, int k) {
         HashMap<Character, Integer> map = new HashMap<>();
         int st = 0;
         int max_len = 0;
         int curr = 0;
         int max_freq = 0;
         for(int end = 0; end<s.length();end++){
            char c = s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            max_freq = Math.max(max_freq,map.get(c));
            while((end-st+1) - max_freq > k){
                map.put(s.charAt(st),map.get(s.charAt(st))-1);
                st++;
            }
            max_len = Math.max(max_len,end-st+1);
         }
    return max_len;
    }
}