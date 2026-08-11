class Solution {
    public int missingInteger(int[] nums) {
        int sum=0;
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                ans.add(nums[i]);
            }
            else{
                break;
            }
        }

        int[] finalAns = ans.stream().mapToInt(Integer::intValue).toArray();

        for(int i=0;i<finalAns.length;i++){
            sum+=finalAns[i];
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sum) {
                sum++;
            }
        }
        return sum;
    }
}