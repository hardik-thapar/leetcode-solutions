class Solution {
    class Pair{
        int[] point = new int[2];
        double dist;
        Pair(int i, int j, double dist){
            this.point[0] = i;
            this.point[1] = j;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(a.dist, b.dist));
        int[][] res = new int[k][2];
        for(int i=0; i<points.length; i++){
            double dist = Math.sqrt(((points[i][0] - 0)*(points[i][0] - 0)) + ((points[i][1] - 0)*(points[i][1] - 0)));
            pq.offer(new Pair(points[i][0], points[i][1], dist));
        }
        if(k==0) return res;
        for(int i=0; i<k; i++){
            Pair temp = pq.poll();
            res[i][0] = temp.point[0];
            res[i][1] = temp.point[1];
        }
        return res;
    }
}