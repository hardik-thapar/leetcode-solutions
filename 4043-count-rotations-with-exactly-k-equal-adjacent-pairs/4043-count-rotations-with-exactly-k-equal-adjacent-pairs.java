class Solution {
    private static int count(String temp){
        int res = 0;
        for(int i=0; i<temp.length()-1; i++){
            if(temp.charAt(i)==temp.charAt(i+1)) res++;
        }
        return res;
    }
    public int countRotations(String s, int k) {
        String temp;
        int res = 0;
        for(int i=0; i<s.length(); i++){
            temp = new String(s.substring(i) + s.substring(0,i));
            if(count(temp)==k) res++;
        }
        return res;
    }
}