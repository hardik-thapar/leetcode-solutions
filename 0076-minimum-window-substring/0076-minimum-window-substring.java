class Solution {
    public String minWindow(String s, String t) {
       HashMap<Character, Integer> tmap = new HashMap<>();
       for (char c: t.toCharArray()){
        tmap.put(c, tmap.getOrDefault(c,0)+1);
       } 
       int need = tmap.size();
       int start = 0;
       int st=0;
       int minLen = Integer.MAX_VALUE;
       int have = 0;

       HashMap<Character, Integer> smap = new HashMap<>();
       for(int end = 0; end < s.length(); end++){
        char c = s.charAt(end);
        smap.put(c,smap.getOrDefault(c,0)+1);
        if (tmap.containsKey(c) && smap.get(c).equals(tmap.get(c))){
            have++;
        }
        while(have == need){
            if((end-st+1)<minLen){
                start = st;
                minLen = end-st+1;
            }
            char left = s.charAt(st);
            smap.put(left,smap.get(left)-1);
            if (tmap.containsKey(left) && smap.get(left) < tmap.get(left)){
                have--;

            }
            st++;
        }
        
       }
        if (minLen == Integer.MAX_VALUE) return "";
        else{
            return s.substring(start,start+minLen);
        }
    }
}