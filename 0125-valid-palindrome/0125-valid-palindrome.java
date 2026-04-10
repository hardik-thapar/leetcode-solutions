class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(Character.isLetterOrDigit(curr)){
                str.append(curr);
            }
        }
        String ans = str.toString().toLowerCase();
        int l=0;
        int r = ans.length()-1;
        while(l<=r){
            if(ans.charAt(l) != ans.charAt(r)){
                return false;
            }
            l+=1;
            r-=1;
        }
        return true;

    }
}