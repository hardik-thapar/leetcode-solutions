class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1!=n2) return false;
        HashMap<Character,Integer> tmap = new HashMap<>();
        for(int x=0;x<n2;x++){
            char c = t.charAt(x);
            if (tmap.containsKey(c)){
                int f = tmap.get(c);
                tmap.put(c,f+1);
            }
            else{
                tmap.put(c,1);
            }
        }

        HashMap<Character,Integer> smap = new HashMap<>();
        for(int i=0;i<n1;i++){
            char c = s.charAt(i);
            if (smap.containsKey(c)){
                int f = smap.get(c);
                smap.put(c,f+1);
            }
            else{
                smap.put(c,1);
            }
        } 

        if (smap.equals(tmap)) return true;
        else return false;


    }
}