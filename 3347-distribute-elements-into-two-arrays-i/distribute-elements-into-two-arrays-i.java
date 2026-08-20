class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        int i=0,j=0;
        for(int k=2;k<=nums.length-1;k++){
            if(arr1.get(i)>arr2.get(j)){
                arr1.add(nums[k]);
                i++;
            }
            else{
                arr2.add(nums[k]);
                j++;
            }
        }

        int ans[]=new int[n];
        int index=0;

        for(int z=0;z<arr1.size();z++){
            ans[index]=arr1.get(z);
            index++;
        }


        for(int z=0;z<arr2.size();z++){
            ans[index]=arr2.get(z);
            index++;
        }
        return ans;
    }
}