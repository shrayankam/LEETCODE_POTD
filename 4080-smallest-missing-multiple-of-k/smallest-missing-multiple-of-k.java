class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }

        int curr=k;
        while(s.contains(curr)){
            curr+=k;
        }

        return curr;
    }
}