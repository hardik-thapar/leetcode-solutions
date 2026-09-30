class Solution {
    private int res = 0;
    private void dfs(int idx, int[] nums, int pos_len, int neg_len){
        if(idx==nums.length) return;
        //case 1: num is positive
        int num = nums[idx];
        if(num > 0){
            pos_len++;
            if(neg_len!=0) neg_len++;
            res = Math.max(res, pos_len);
            dfs(idx+1, nums, pos_len, neg_len);
        }
        // case 2: num is neg
        else if(num < 0){
            int temp = pos_len;
            if(neg_len!=0) pos_len = neg_len+1;
            else pos_len = 0;
            neg_len = temp+1;
            res = Math.max(res, pos_len);
            dfs(idx+1, nums, pos_len, neg_len);
        }

        else {
            res = Math.max(res, pos_len);
            pos_len = 0;
            neg_len = 0;
            dfs(idx+1, nums, pos_len, neg_len);
        }
        return;
    }
    public int getMaxLen(int[] nums) {
        dfs(0, nums, 0, 0);
        return res;
    }
}