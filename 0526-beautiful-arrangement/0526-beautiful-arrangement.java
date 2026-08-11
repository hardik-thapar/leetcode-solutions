class Solution {
    private int cnt = 0;
    private void dfs(int[] freq, int x){
        if(x>freq.length-1){
            cnt++;
            return;
        }

        for(int i=1; i<freq.length; i++){
            if(freq[i]==1){
                if(i%x==0 || x%i==0){
                    freq[i]=0;
                    dfs(freq, x+1);
                    freq[i]=1;
                }

            }
        }
        return;
    }
    public int countArrangement(int n) {
        int[] freq = new int[n+1];
        Arrays.fill(freq, 1);
        dfs(freq, 1);
        return cnt;
    }
}