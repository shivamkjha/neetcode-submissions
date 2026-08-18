class Solution {

    public String encode(List<String> strs) {
        String encoded = "";

        for(String s : strs){
            int len = s.length();
            encoded += len;
            encoded += '#';
            encoded += s;
        }

        return encoded;
    }

    public List<String> decode(String str) {
        int length = str.length();
        List<String> ans = new ArrayList<>();

        int i = 0;
        while(i < length){
            int j = i;
            String len = "";
            while(str.charAt(j) != '#'){
                len += str.charAt(j);
                j++;
            }

            int l = Integer.parseInt(len);

            int s = j+1;
            int e = s + l;

            ans.add(str.substring(s,e));
            i = e;
        }

        return ans;
    }
}
