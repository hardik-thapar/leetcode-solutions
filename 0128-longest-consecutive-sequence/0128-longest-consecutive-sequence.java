class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n: nums){
            set.add(n);
        }
        int max_count = 0;
        for(int n: set){
            int x = n;
            int count = 1;
            if (!set.contains(x-1)){
                while(set.contains(x+1)){
                    count++;
                    x++;
                }
            }
            max_count = Math.max(max_count,count);
        }
        return max_count;
    }
}