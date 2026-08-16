class Solution {

    public int nearestDrone(int[][] drones, int[] target) {
        int result = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<drones.length; i++){
            int dist = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
            if(dist <= drones[i][2]){
                if(dist==result){
                    idx = Math.min(i, idx);
                }
                if(dist < result){
                    result = dist;
                    idx = i;
                }
            }
        }

        if(idx==Integer.MIN_VALUE) return -1;
        return idx;
    }
}