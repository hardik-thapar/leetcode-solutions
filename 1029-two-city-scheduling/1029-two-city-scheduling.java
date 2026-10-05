class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //send all people to a city, then pick exactly n/2 people -> send them to another city such a way that u minimise the total cost

        int t_cost = 0;
        for(int i=0; i<costs.length; i++) t_cost += costs[i][0];
        Arrays.sort(costs, (a,b)->Integer.compare(a[1]-a[0], b[1]-b[0]));
        for(int i=0; i<costs.length/2; i++){
            t_cost = t_cost - costs[i][0] + costs[i][1];
        }
        return t_cost;
    }
}