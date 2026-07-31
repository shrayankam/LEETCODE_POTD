//solution

class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char ch : word.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list, Collections.reverseOrder());

        int ans = 0;
        int i = 0;

        for (int value : list) {
            if (i < 8) {
                ans += value;
            } else if (i < 16) {
                ans += value * 2;
            } else if (i < 24) {
                ans += value * 3;
            } else {
                ans += value * 4;
            }
            i++;
        }

        return ans;
    }
}
