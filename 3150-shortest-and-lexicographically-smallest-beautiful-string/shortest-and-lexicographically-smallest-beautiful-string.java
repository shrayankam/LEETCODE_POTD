class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int total = 0;
        for (int i = 0; i < s.length(); i++){
            total += s.charAt(i) - '0';
        }
        String ans = s;
        int count = 0,left = 0;

        if (total < k) {
            return "";
        }

        for (int right = 0; right < s.length(); right++) {
            count += s.charAt(right) - '0';
            while (count > k || s.charAt(left) == '0') {
                count -= s.charAt(left++) - '0';
            }
            if (count == k) {
                String t = s.substring(left, right + 1);
                if (
                    t.length() < ans.length() ||
                    (t.length() == ans.length() && t.compareTo(ans) < 0)
                ) {
                    ans = t;
                }
            }
        }
        return ans;
    }
}