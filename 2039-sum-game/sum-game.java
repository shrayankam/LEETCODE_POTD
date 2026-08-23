class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int first=0,sec=0;
        int s1=0,s2=0;
        for(int i=0;i<n/2;i++)
        {
            if(num.charAt(i)=='?')first++;
            else s1+=(num.charAt(i)-'0');
        }
        for(int i=n/2;i<n;i++)
        {
            if(num.charAt(i)=='?') sec++;
            else s2+=(num.charAt(i)-'0');
        }
        
        return (s1 - s2) * 2 != (sec - first) * 9;
    }
}