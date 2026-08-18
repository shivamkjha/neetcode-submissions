class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = search(i,j,0,word,visited,board);
                    if(ans == true) return true;
                }
            }
        }
        return false;
    }

    boolean search(int r, int c, int index, String word, int[][] visited, char[][] board){
        int rowMax = board.length;
        int colMax = board[0].length;

        // Invalid condition
        if(r >= rowMax || c >= colMax || r < 0 || c < 0 || board[r][c] != word.charAt(index) || visited[r][c] == 1){
            return false;
        }

        // base condition
        if(index == word.length() -1){
            return true;
        }


        visited[r][c] = 1;
        index++;
        boolean ans = search(r+1,c,index,word,visited,board) || search(r-1,c,index,word,visited,board) || search(r,c+1,index,word,visited,board) || search(r,c-1,index,word,visited,board);
        visited[r][c] = 0;
            
        return ans;
    }
}
