class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=n+10;i++){
            int prod=1;
            int ans=i;
            while(ans>0){
                int rem=ans%10;
                prod*=rem;
                ans/=10;
            }
            if(prod%t==0){
                return i;
            }
            System.out.print(i);
        }
        return 0;
    }
}