class Solution {
    public boolean stoneGame(int[] piles) {
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