class Solution {
    public int minimumPushes(String word) {
        int freq[]=new int[8];
        int i=0,j=0,count=0;
        while(i<word.length()){
            if(j<freq.length){
                count++;
                System.out.print(count+",");
            }else if(j<freq.length*2){
                count+=2;
            }else if(j<freq.length*3){
                count+=3;
            }else{
                count+=4;
            }
            i++;
            j++;
        }
        return count;
    }
}