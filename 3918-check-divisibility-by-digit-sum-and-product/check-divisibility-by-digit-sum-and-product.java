class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,prod=1,total=0;
        int temp=n;

        while(temp>0){
            int rem=temp%10;
            sum+=rem;
            prod*=rem;
            temp/=10;
        }

        total=sum+prod;

        if(n%total==0){
            return true;
        }
        return false;
    }
}