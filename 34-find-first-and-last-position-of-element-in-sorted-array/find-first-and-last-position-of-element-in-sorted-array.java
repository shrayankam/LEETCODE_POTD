class Solution {
    public int lowerbound(int nums[], int target) {
        int lb = nums.length;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                lb = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lb;
    }

    public int upperbound(int nums[], int target) {
        int ub = nums.length;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                ub = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ub;
    }

    public int[] searchRange(int[] nums, int target) {
        // if (nums == null || nums.length == 0) {
        //     return new int[]{-1, -1};
        // }

        int lb = lowerbound(nums, target);
        if (lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        int ub = upperbound(nums, target);
        return new int[]{lb, ub - 1};
    }
}