class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans =new ArrayList<>();
        List<String>res=new ArrayList<>();
        partPalin(s,0,ans,res);
        return ans;
    }


    public void partPalin(String s, int idx, List<List<String>> ans, List<String>res){
        if(idx==s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                res.add(s.substring(idx,i+1));
                partPalin(s, i+1, ans, res);
                res.remove(res.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int i, int j){
            while(i<=j){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
