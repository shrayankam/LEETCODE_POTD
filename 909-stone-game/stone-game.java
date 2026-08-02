class Solution {
    public boolean stoneGame(int[] piles) {
        // int n = piles.length;
        // int[][] dp = new int[n][n];

        // for (int i = 0; i < n; i++)
        //     dp[i][i] = piles[i];

        // for (int len = 2; len <= n; len++) {
        //     for (int i = 0; i + len - 1 < n; i++) {
        //         int j = i + len - 1;

        //         int takeLeft = piles[i] - dp[i + 1][j];
        //         int takeRight = piles[j] - dp[i][j - 1];

        //         dp[i][j] = Math.max(takeLeft, takeRight);
        //     }
        // }

        // return dp[0][n - 1] >= 0;

        int l=0,r=piles.length-1,AliceS=0,BobS=0,Amax=0,Bmax=0;
        boolean Alice=true, Bob=false;

        while(l<r){
            if(Alice){
                Amax=Math.max(piles[l],piles[r]);
                AliceS+=Amax;
                if(AliceS-Amax==piles[l]){
                    l++;
                }else{
                    r--;
                }
            }else{
                Bmax=Math.max(piles[l],piles[r]);
                BobS+=Bmax;
                if(BobS-Bmax==piles[l]){
                    l++;
                }else{
                    r--;
                }
            }
        }
        if(AliceS>BobS){
            return true;
        }
        return false;
    }
}