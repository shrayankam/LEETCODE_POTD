class Solution {
    public int firstStableIndex(int[] a, int k) {
        int n=a.length;
        int[] suffixMin = new int[a.length];
        suffixMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(a[i], suffixMin[i + 1]);
        }
        
        int prefixMax[]=new int[a.length];
        prefixMax[0]=a[0];
        for(int i=1;i<n;i++){
            prefixMax[i]=Math.max(a[i],prefixMax[i-1]);
        }

        for(int i=0;i<n;i++){
            if(prefixMax[i]-suffixMin[i]<=k){
                return i;
            }
        }


        // for(int i=0;i<n;i++){
        //     System.out.print(prefixMax[i]+","+suffixMin[i]+"\n");
        // }
        return -1;
    }
}