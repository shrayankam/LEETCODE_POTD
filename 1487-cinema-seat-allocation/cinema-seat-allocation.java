class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Character> hm = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0] - 1;
            int col = reservedSeats[i][1];
            
            if (!hm.containsKey(row)) {
                hm.put(row, (char) 7);
            }

            char currentMask = hm.get(row);

            if (col == 2 || col == 3) {
                hm.put(row, (char) (currentMask & 3)); 
            } else if (col == 4 || col == 5) {
                hm.put(row, (char) (currentMask & 1)); 
            } else if (col == 6 || col == 7) {
                hm.put(row, (char) (currentMask & 4)); 
            } else if (col == 8 || col == 9) {
                hm.put(row, (char) (currentMask & 6)); 
            }
        }

        int res = (n - hm.size()) * 2;
        for (Map.Entry<Integer, Character> entry : hm.entrySet()) {
            char v = entry.getValue();
            if (v == 5 || v == 7) {
                res += 2;
            } else if (v != 0) {
                res += 1;
            }
        }

        return res;
    }
}
