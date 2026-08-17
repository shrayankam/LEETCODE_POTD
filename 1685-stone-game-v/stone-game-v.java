class Solution {
    private int[][] memo;
    private int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(memo[i], -1);
        }

        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        return solve(0, n - 1, stoneValue);
    }

    private int solve(int l, int r, int[] arr) {
        if (l == r) {
            return 0;
        }
        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int ans = 0;
        for (int k = l; k < r; k++) {
            int leftSum = getSum(l, k);
            int rightSum = getSum(k + 1, r);

            if (leftSum < rightSum) {
                ans = Math.max(ans, leftSum + solve(l, k, arr));
            } else if (rightSum < leftSum) {
                ans = Math.max(ans, rightSum + solve(k + 1, r, arr));
            } else {
                ans = Math.max(ans, Math.max(
                    leftSum + solve(l, k, arr),
                    rightSum + solve(k + 1, r, arr)
                ));
            }
        }

        return memo[l][r] = ans;
    }

    private int getSum(int l, int r) {
        return prefixSum[r + 1] - prefixSum[l];
    }
}
