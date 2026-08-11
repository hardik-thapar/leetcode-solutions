class Solution {
    private char[] bits = {'0','1'};
    private int n;
    private String res;
    private HashSet<String> set = new HashSet<>();
    private void dfs(StringBuffer curr){
        if(curr.length()==n){
            if(!set.contains(curr.toString())) res = new String(curr);
            return;
        }
        curr.append('0');
        dfs(curr);
        curr.deleteCharAt(curr.length()-1);
        curr.append('1');
        dfs(curr);
        curr.deleteCharAt(curr.length()-1);
        return;
    }
    public String findDifferentBinaryString(String[] nums) {
        n = nums[0].length();
        for(String s: nums) set.add(s);
        dfs(new StringBuffer(""));
        return res;
    }
}