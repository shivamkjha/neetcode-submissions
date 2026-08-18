class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode curr = root;

        for(int i = 0;i<n;i++){
            int charIdx = word.charAt(i) - 'a';

            if(curr.children[charIdx] == null){
                curr.children[charIdx] = new TrieNode();
            }

            if(i == n-1){
                curr.wordEnd = true;
            }else{
                curr = curr.children[charIdx];
            }
        }
    }

    public boolean search(String word) {
        int n = word.length();
        TrieNode curr = root;

        for(int i = 0;i<n;i++){
            int charIdx = word.charAt(i) - 'a';

            if(curr.children[charIdx] == null){
                return false;
            }

            if(i != n-1){
                curr = curr.children[charIdx];
            }
        }

        return curr.wordEnd == true;
    }

    public boolean startsWith(String word) {
        int n = word.length();
        TrieNode curr = root;

        for(int i = 0;i<n;i++){
            int charIdx = word.charAt(i) - 'a';

            if(curr.children[charIdx] == null){
                return false;
            }
            curr = curr.children[charIdx];
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean wordEnd = false;
}
