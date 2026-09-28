class Solution {
    public int findMaxLength(int[] nums) {
        //
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) pre+=-1;
            else pre+=1;

            if(pre==0){
                res = Math.max(res, i+1);
            }
            // map.putIfAbsent(pre, i);
            else if(map.containsKey(pre)){
                res = Math.max(res, i - map.get(pre));
            }
            else map.put(pre, i);
        }
        return res;
    }
}