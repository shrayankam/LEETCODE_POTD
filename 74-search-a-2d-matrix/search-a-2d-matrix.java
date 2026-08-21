class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
    
        int start=0;
        int end=arr.length*arr[0].length-1;
        while(start<=end){
            int mid=(start+end)/2;
            int row=mid/arr[0].length;
            int col=mid%arr[0].length;
            if(arr[row][col]==target){
                return true;
            }else if(arr[row][col]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}