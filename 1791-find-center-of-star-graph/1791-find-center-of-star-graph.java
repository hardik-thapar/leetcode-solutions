class Solution {
    public int findCenter(int[][] edges) {
        int f1 = edges[0][0];
        int f2 = edges[0][1];
        int s1 = edges[1][0];
        int s2 = edges[1][1];
        if(f1==s1) return s1;
        else if(f1==s2) return s2;
        else return f2;

    }
}