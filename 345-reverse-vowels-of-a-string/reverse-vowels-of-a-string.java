class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray(); 
        int i = 0;
        int r = s.length() - 1;
        
        while (i < r) {
            if (isVowel(chars[i]) && isVowel(chars[r])) {
                char temp = chars[i];
                chars[i] = chars[r];
                chars[r] = temp;
                i++;
                r--;
            } else if (!isVowel(chars[i])) {
                i++;
            } else if(!isVowel(chars[r])){
                r--;
            }
        }
        return new String(chars); 
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
