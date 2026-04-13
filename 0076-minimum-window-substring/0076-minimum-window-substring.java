class Solution {
    public String minWindow(String s, String t) {
        // a map for t freq
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        
        int st=0;
        int have = 0;
        int need = tmap.size();
        int min_len = Integer.MAX_VALUE;
        int start = 0;
        // keeping a track of window with map 
        HashMap<Character, Integer> smap = new HashMap<>();
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            smap.put(c,smap.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && tmap.get(c).equals(smap.get(c))){
                have++;
            }
            while(have == need){
                // min_len = Math.min(min_len,end-st+1);
                char x = s.charAt(st);
                if((end-st+1) < min_len){
                    min_len = end-st+1;
                    start = st;
                }
                smap.put(x,smap.get(x)-1);
                // if(smap.get(s.charAt(st)) <= 0){
                //     smap.remove(s.charAt(st));
                // }
                
                if(tmap.containsKey(x) && (smap.get(x) < tmap.get(x))){
                    have--;
                }

            st++;
            }
        }
        if(min_len == Integer.MAX_VALUE) {return ""; }
        else{
        return s.substring(start,start+min_len); }
    }
}