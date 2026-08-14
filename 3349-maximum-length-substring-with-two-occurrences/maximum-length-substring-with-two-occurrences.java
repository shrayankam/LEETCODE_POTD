class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> hm=new HashMap<>();
        int l=0,r=0,len=0,max=0;
        while(r<s.length()){
            char key=s.charAt(r);
            hm.put(key, hm.getOrDefault(key, 0) + 1);

            while(hm.get(key)>2){
                char leftChar = s.charAt(l);
                hm.put(leftChar, hm.get(leftChar) - 1);
                l++; 
            }
            len=r-l+1;
            max=Math.max(max,len);
            r++;
        }
        return max;
    }
}