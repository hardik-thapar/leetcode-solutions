class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int i, int n, int k, List<Integer> curr){
        if(i>n){
            if(curr.size()==k) ans.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(i);
        dfs(i+1, n, k, curr);
        curr.remove(curr.size()-1);
        dfs(i+1, n, k, curr);
        return;
    }
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k, new ArrayList<>());
        return ans;
    }
}