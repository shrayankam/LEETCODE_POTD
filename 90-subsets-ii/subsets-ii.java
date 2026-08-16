class Solution {

    public void subset(int idx,int arr[],Set<List<Integer>> set,ArrayList<Integer>ds){

        if(idx==arr.length){
            List<Integer> currentSubset = new ArrayList<>(ds);
            Collections.sort(currentSubset);
            set.add(currentSubset); 
            return; 
        }

        ds.add(arr[idx]);
        subset(idx+1,arr,set,ds);
        ds.remove(ds.size()-1);
        subset(idx+1,arr,set,ds);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        subset(0,nums,set,new ArrayList<>());
        return new ArrayList<>(set);
    }
}