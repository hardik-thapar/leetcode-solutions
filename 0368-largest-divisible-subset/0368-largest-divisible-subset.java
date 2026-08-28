class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] list = new ArrayList[nums.length];
        for(int i=0; i<nums.length; i++) list[i] = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int idx = -1;
            int currSize = Integer.MIN_VALUE;
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0){
                    if(list[j].size() > currSize){
                        idx = j;
                        currSize = list[j].size();
                    }
                } 
            }
            if(idx!=-1) list[i] = new ArrayList(list[idx]);
            list[i].add(nums[i]);
        }
        int temp = 0;
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(list[i].size() > temp){
                res = i;
                temp = list[i].size();
            }
        }
        return list[res];
    }
}