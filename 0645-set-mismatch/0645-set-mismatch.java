class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = nums.length;
        int dup = 0;
        for(int x: nums){
            if(set.contains(x)) dup = x;
            set.add(x);
            // max = Math.max(max,x);
        }
        int ssum = 0;
        for(int x: set){
            ssum+=x;
        }
        int nsum = (max*(max+1))/2;
        int[] res = new int[2];
        res[0]=dup;
        res[1] = nsum - ssum;
        return res;
    }
}