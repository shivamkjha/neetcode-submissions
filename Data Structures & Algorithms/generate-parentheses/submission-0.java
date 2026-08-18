class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<String>();
        parenthesis(0,0,n,sb,ans);
        return ans;
    }

    void parenthesis(int open,int close,int n, StringBuilder sb,List<String> ans){
        if(open == n && close == n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            parenthesis(open+1,close,n,sb,ans);
            sb.delete(sb.length()-1,sb.length());
        }

        if(close < open){
            sb.append(')');
            parenthesis(open,close+1,n,sb,ans);
            sb.delete(sb.length()-1,sb.length());
        }
    }
}
