class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n<=2) return 1;
        int[] val = new int[n+1];
        val[0] = 0;
        val[1] = 1;
        val[2] = 1;
        int i = 3;
        while(i <= n){
            val[i] = val[i-1] + val[i-2] + val[i-3];
            i++;
        }
        return val[n];
    }
}