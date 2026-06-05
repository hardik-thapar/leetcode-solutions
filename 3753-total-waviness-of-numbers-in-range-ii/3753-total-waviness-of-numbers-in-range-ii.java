class Solution {

    static class Pair {
        long count;
        long sum;

        Pair(long c, long s) {
            count = c;
            sum = s;
        }
    }

    String digits;
    Pair[][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        digits = String.valueOf(x);

        int n = digits.length();

        memo = new Pair[n][11][11][2];

        Pair ans = dfs(0, 10, 10, 1);

        return ans.sum;
    }

    private Pair dfs(int pos, int prev2, int prev1, int tight) {

        if (pos == digits.length()) {
            return new Pair(1, 0);
        }

        if (tight == 0 && memo[pos][prev2][prev1][0] != null)
            return memo[pos][prev2][prev1][0];

        int limit = (tight == 1)
                ? digits.charAt(pos) - '0'
                : 9;

        long totalCount = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            int newTight =
                    (tight == 1 && d == limit)
                            ? 1
                            : 0;

            int np2 = prev2;
            int np1 = prev1;

            int add = 0;

            if (prev1 == 10) {

                if (d != 0) {
                    np1 = d;
                }

            } else if (prev2 == 10) {

                np2 = prev1;
                np1 = d;

            } else {

                if ((prev2 < prev1 && prev1 > d) ||
                    (prev2 > prev1 && prev1 < d)) {
                    add = 1;
                }

                np2 = prev1;
                np1 = d;
            }

            Pair child = dfs(pos + 1, np2, np1, newTight);

            totalCount += child.count;
            totalSum += child.sum + (long)add * child.count;
        }

        Pair ans = new Pair(totalCount, totalSum);

        if (tight == 0)
            memo[pos][prev2][prev1][0] = ans;

        return ans;
    }
}