class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(sum==k) cnt++;
            if(map.containsKey(sum-k)) cnt+=map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return cnt;
    }
}