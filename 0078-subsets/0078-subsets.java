class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int i, int[] nums, List<Integer> curr){
        if(i==nums.length){ 
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        dfs(i+1, nums, curr);

        curr.remove(curr.size()-1);
        dfs(i+1, nums, curr);

        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return ans;
    }
}