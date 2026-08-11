class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        char[] res = new char[n];
        for(int i=0; i<n; i++){
            res[i] = nums[i].charAt(i);
            if(res[i]=='0') res[i] = '1';
            else res[i] = '0';
        }
        return new String(res);
    }
}