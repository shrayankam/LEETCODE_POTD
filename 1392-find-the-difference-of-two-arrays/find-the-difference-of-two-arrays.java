class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> a1=new ArrayList<>();
        Set<Integer> s1 = new HashSet<>();
        List<Integer> a2=new ArrayList<>();
        Set<Integer> s2 = new HashSet<>();


        for(int i=0;i<nums1.length;i++){
            s1.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            s2.add(nums2[i]);
        }


        for(int i=0;i<nums1.length;i++){
            if(!(s2.contains(nums1[i])) && !(a1.contains(nums1[i]))){
                a1.add(nums1[i]);
            }
        }

        for(int i=0;i<nums2.length;i++){
            if(!(s1.contains(nums2[i])) && !(a2.contains(nums2[i]))){
                a2.add(nums2[i]);
            }
        }
        
        ans.add(a1);
        ans.add(a2);
        return ans;
    }
}