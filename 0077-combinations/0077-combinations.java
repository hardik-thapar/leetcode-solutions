class Solution {
    private int K;
    private int N;
    private List<List<Integer>> res = new ArrayList<>();
    private void dfs(int idx, List<Integer> curr){
        if(idx>N){
            if(curr.size()==K) res.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()==K){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(idx);
        dfs(idx+1, curr);
        curr.remove(curr.size()-1);
        dfs(idx+1, curr);
        return;
        
    }
    public List<List<Integer>> combine(int n, int k) {
        K=k;
        N=n;
        dfs(1, new ArrayList<>());
        return res;
    }
}