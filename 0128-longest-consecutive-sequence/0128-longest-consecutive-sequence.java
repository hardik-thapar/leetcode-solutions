class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x: nums){
            set.add(x);
        }
        int m=0;
        for(int x: set){
            int count=1;
            // int x = nums[i];
            if (!set.contains(x-1)){
                while(set.contains(x+1)){
                    count++;
                    x=x+1;
                }
            }
            m=Math.max(m,count);

        }
        return m;
    }
}