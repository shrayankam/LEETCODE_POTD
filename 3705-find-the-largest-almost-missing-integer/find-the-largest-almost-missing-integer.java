class Solution {

    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int ans = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();

        if (k == n) {
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, nums[i]);
            }
        } 
        else if (k == 1) {
            for (int i = 0; i < n; i++) {
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = Math.max(ans, entry.getKey());
                }
            }
        } 
        else {
            for (int i = 0; i < n; i++) {
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            }

            if (hm.get(nums[0]) == 1) {
                ans = Math.max(ans, nums[0]);
            }

            if (hm.get(nums[n - 1]) == 1) {
                ans = Math.max(ans, nums[n - 1]);
            }
        }

        return ans;
    }
}