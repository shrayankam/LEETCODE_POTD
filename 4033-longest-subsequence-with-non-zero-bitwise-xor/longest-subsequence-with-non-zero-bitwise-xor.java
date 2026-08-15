class Solution {
    public int longestSubsequence(int[] nums) {
        int zeroCount=0;
        int total=0;

        for(int i=0;i<nums.length;i++){
            total^=nums[i];
            if(nums[i]==0){
                zeroCount++;
            }
        }


        if(total!=0){
            return nums.length;
        }

        if(zeroCount==nums.length){
            return 0;
        }


        return nums.length-1;
    }
}
