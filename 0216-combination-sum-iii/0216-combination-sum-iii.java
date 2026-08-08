class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int i, int k, int n, int sum, List<Integer> curr){
        if(i>9){
            if(curr.size()==k && sum==n) ans.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()>k) return;
        if(curr.size()==k && sum==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(i);
        dfs(i+1, k, n, sum+i, curr);
        curr.remove(curr.size()-1);
        dfs(i+1, k, n, sum, curr);
        return;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,k,n,0,new ArrayList<>());
        return ans;
    }
}