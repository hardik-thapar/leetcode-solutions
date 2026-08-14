class Solution {
    private boolean[] used;
    private List<List<Integer>> res = new ArrayList<>();
    private int[] numbers;
    private void dfs(List<Integer> curr){
        if(curr.size()==used.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<used.length; i++){
            if(!used[i]){
                used[i] = true;
                curr.add(numbers[i]);
                dfs(curr);
                used[i] = false;
                curr.remove(curr.size()-1);
            }
        }

        return;

    }
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        numbers = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            numbers[i] = nums[i];
        }
        dfs(new ArrayList<>());
        return res;
    }
}