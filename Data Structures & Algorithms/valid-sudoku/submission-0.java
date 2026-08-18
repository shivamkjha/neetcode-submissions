class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean ans = true;

        // check 1 : each row
        for(char[] row : board){
            HashSet<Integer> set = new HashSet<>();

            for(int i = 0;i<9;i++){
                if(row[i] == '.') continue;
                int num = row[i] - '0';
                
                if(num < 1 || num > 9) return false;
                if(set.contains(num)) return false;

                set.add(num);
            }

            set.clear();
        }

        // check 2 : each col
        for(int i = 0;i<9;i++){
            HashSet<Integer> set = new HashSet<>();

            for(int j = 0;j<9;j++){
                if(board[j][i] == '.') continue;

                int num = board[j][i] - '0';

                if(num < 1 || num > 9) return false;
                if(set.contains(num)) return false;

                set.add(num);
            }

            set.clear();
        }

        // check 3 : 3*3 matrix 
        
        // starting positions
        for(int i = 0;i<9;i=i+3){
            for(int j = 0;j<9;j=j+3){

                // loop in a 3*3 matrix
                HashSet<Integer> set = new HashSet<>();

                for(int k = i;k<i+3;k++){
                    for(int l = j;l<j+3;l++){
                        if(board[k][l] == '.') continue;

                        int num = board[k][l] - '0';

                        if(num < 1 || num > 9) return false;
                        if(set.contains(num)) return false;

                        set.add(num);
                    }
                }

                set.clear();
            }
        }

        return ans;
    }

    
}
