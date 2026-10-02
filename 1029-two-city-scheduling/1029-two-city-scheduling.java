class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int t_price = 0;
        for(int i=0; i<costs.length; i++){
            t_price += costs[i][0];
        }
        //now we have total price as if we are sending all teh candidates to cityA, now we have to choose exactly n/2 candidates and send them to cityB. for that we follow a greedy approach that :
        // we switch a candidate from city A -> B:
        // we have deduct its cityA cost, and add its CityB cost, so we are doing is for n/2 times we are performing:
        // t_price += cityBi - cityAi
        // and also we have to minimise the t_price so we have to negate the term (cityBi - cityAi) with the max abs value

        //we sort on that basis
        Arrays.sort(costs, (a,b)->Integer.compare( a[1]-a[0], b[1]-b[0]));

        for(int i=0; i<costs.length/2; i++){
            t_price += costs[i][1] - costs[i][0];
        }

        return t_price;
    }
}