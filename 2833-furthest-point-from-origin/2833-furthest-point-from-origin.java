class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int[] freq = new int[3];
        for(char c: moves.toCharArray()){
            if(c=='L') freq[0]++;
            else if(c=='R') freq[2]++;
            else freq[1]++;
        }
        if(freq[0] == freq[2]) return freq[1];
        else if(freq[0]>freq[2]) return freq[0]+freq[1]-freq[2];
        else return freq[2]+freq[1]-freq[0];
    }
}