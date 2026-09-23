class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private void dfs(int idx, List<Integer> curr, int target, int[] nums){
        if(idx==nums.length){
            if(target==0){
                res.add(new ArrayList(curr));
            }
            return;
        }
        if(target==0){
            res.add(new ArrayList(curr));
            return;
        }
        if(target<0) return;
        curr.add(nums[idx]);
        dfs(idx, curr, target-nums[idx], nums);
        curr.remove(curr.size()-1);
        dfs(idx+1, curr, target, nums);
        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), target, candidates);
        return res;
    }
}