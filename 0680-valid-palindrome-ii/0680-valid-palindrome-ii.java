class Solution {
    public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                if(isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1)) return true;
                else return false;
            }
            left++;
            right--;
        }
        return true;
    }
}