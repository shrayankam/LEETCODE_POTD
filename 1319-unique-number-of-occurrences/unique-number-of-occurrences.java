class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // 1. Count frequencies
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        
        for (int val : hm.values()) {
            if (!set.add(val)) {
                return false; 
            }
        }
        
        return true;
    }
}
