#solution

class Solution {
    public String smallestPalindrome(String s) {
        int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        StringBuilder left=new StringBuilder("");
        String middle="";
        for(int i=0;i<count.length;i++){
            while(count[i]>=2){
                left.append((char)(i + 'a'));
                count[i]-=2;
            }

            if(count[i]==1){
                middle = String.valueOf((char)(i + 'a'));
            }
        }

        String right = left.reverse().toString();
        left.reverse();

        return left.toString()+middle+right;
    }
}
