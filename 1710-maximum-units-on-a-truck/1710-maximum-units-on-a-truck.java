class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->Integer.compare(b[1], a[1]));
        int res = 0;
        for(int i=0; i<boxTypes.length; i++){
            if(truckSize >= boxTypes[i][0]){
                res+= boxTypes[i][1] * boxTypes[i][0];
                truckSize -= boxTypes[i][0];
            }
            else{
                res+= boxTypes[i][1]*truckSize;
                truckSize=0;
            }
        }
        return res;
    }
}