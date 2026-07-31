class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> hm=new HashMap<>();
        int totalSum=0;
        for(int i=0;i<word.length();i++){
            char key=word.charAt(i);
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
 

Map<Character, Integer> sortedMap = hm.entrySet()
            .stream()
            .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
            .collect(Collectors.toMap(
                Map.Entry::getKey, 
                Map.Entry::getValue, 
                (e1, e2) -> e1, 
                LinkedHashMap::new // Maintains the descending order
            ));

        // 2. Print the sorted letters and frequencies


        int i=0;
        for(Integer value:sortedMap.values()){
            if(i<8){
                totalSum+=value;
                i++;
            }
            else if(i>=8 && i<16){
                totalSum+=(value*2);
                i++;
            }else if(i>=16 && i<24){
                totalSum+=(value*3);
                i++;
            }else{
                totalSum+=(value*4);
                i++;
            }
        }

//         System.out.println(hm);
        System.out.println(sortedMap); 
        return totalSum;
    }
}