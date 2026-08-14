class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int K;
    private int N;
    // private boolean[] used = new boolean[10];
    private void dfs(int idx, List<Integer> curr, int sum){
        
        if(idx>9) {
            if(curr.size()==K && sum==N) res.add(new ArrayList<>(curr));
            return;
        }

        if(curr.size()==K){
            if(sum==N) res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(idx);
        sum+=idx;
        dfs(idx+1, curr, sum);
        curr.remove(curr.size()-1);
        sum-=idx;
        dfs(idx+1, curr, sum);
        return;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        K=k;
        N=n;
        dfs(1, new ArrayList<>(), 0);
        return res;
    }
}