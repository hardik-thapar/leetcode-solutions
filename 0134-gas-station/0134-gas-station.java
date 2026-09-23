class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int t1 = 0;
        int t2 = 0;
        for(int i=0; i<gas.length; i++){
            t1+=gas[i];
            t2+=cost[i];
        }
        if(t1<t2) return -1;
        int amt = 0;
        int ans = 0;
        int i = 0;
        while(i<gas.length){
            amt+=gas[i];
            amt-=cost[i];
            if(amt<0){
                amt=0;
                ans = i+1;
            }
            i++;
        }

        return ans;

    }
}