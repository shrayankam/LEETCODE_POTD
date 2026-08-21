class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length;

        while(l<=r){
            int mid=(l+r)/2;
            if(l==mid && r==mid){
                return mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return 0;
    }
}