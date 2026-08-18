class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> ans = new ArrayList<>();
        comb(ans,digits,0,map,new StringBuilder());
        return ans;
    }

    void comb(List<String> ans,String digits,int idx,Map<Character,String> map,StringBuilder sb){
        if(digits.length() == 0) return;
        
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }

        String numStr = map.get(digits.charAt(idx));
        int n = numStr.length();

        for(int i = 0;i<n;i++){
            sb.append(numStr.charAt(i));
            comb(ans,digits,idx+1,map,sb);
            sb.delete(sb.length() -1, sb.length());
        }
    }
}