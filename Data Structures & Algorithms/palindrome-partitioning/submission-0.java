class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        soln(ans,s,new ArrayList<>(),0);
        return ans;
    }

    void soln(List<List<String>> ans,String s,List<String> curr,int idx){
        if(idx == s.length()){
            ans.add(new ArrayList(curr));
            return;
        }


            for(int j = idx;j<s.length();j++){
                String subStr = s.substring(idx,j+1);
                if(!isPalindrome(subStr)) continue;
                curr.add(subStr);
                soln(ans,s,curr,j+1);
                curr.remove(curr.size() -1);
            }

    }

    boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;

        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
