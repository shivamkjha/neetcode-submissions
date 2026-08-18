class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int idx = c - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            int idx = (int)(c - 'a');

            if(c == '.'){
                for(int j = 0;j<curr.children.length;j++){
                    
                    if(curr.children[j] != null){
                        boolean searchRes = helper(curr.children[j],word,i+1);
                        if(searchRes) return true;
                    }
                    
                }
                return false;
            }else{
                if(curr.children[idx] == null){
                    return false;
                }
                curr = curr.children[idx];
            }
        }
        return curr.endOfWord;
    }

    public boolean helper(TrieNode curr,String word, int index) {

        for(int i = index;i<word.length();i++){
            char c = word.charAt(i);
            int idx = (int)(c - 'a');

            if(c == '.'){
                for(int j = 0;j<curr.children.length;j++){
                    
                    if(curr.children[j] != null){
                        boolean searchRes = helper(curr.children[j],word,i+1);
                        if(searchRes) return true;
                    }
                    
                }
                return false;
            }else{
                if(curr.children[idx] == null){
                    return false;
                }
                curr = curr.children[idx];
            }
        }
        return curr.endOfWord;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}