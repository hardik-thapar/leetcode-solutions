class Solution {
    private Set<List<Integer>> set = new HashSet<>();
    private List<List<Integer>> res = new ArrayList<>();
    private void dfs(int i, int[] nums, List<Integer> curr){
        if(i == nums.length){
            if(!set.contains(curr)){
                set.add(curr);
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(nums[i]);
        dfs(i+1, nums, curr);
        curr.remove(curr.size()-1);
        dfs(i+1, nums, curr);
        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>());
        return res;
    }
}