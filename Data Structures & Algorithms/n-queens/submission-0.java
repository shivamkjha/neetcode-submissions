class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] vis = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans,new ArrayList<>(),vis,n,0);
        return ans;
    }
    void backtrack(List<List<String>> ans,List<String> curr,int[][] vis,int n, int row){
        if(row == n){
            ans.add(new ArrayList(curr));
            return;
        }

        for(int col = 0;col<n;col++){
            if(!isSafe(row,col,n,vis)) continue;

            vis[row][col] = 1;
            String tempStr = buildString(col,n);
            curr.add(tempStr);
            backtrack(ans,curr,vis,n,row+1);
            curr.remove(curr.size() -1);
            vis[row][col] = 0;
        }
    }

    boolean isSafe(int row,int col, int n, int[][] vis){
        // vertical
        for(int i = 0;i<row;i++){
            if(vis[i][col] == 1){
                return false;
            }
        }

        // cross up - right
        int r = row;
        int c = col;
        while(r-1>=0 && c+1 <n){
            if(vis[r-1][c+1] == 1) return false;
            r--;;
            c++;
        }

        r = row;
        c = col;
        while(r-1>=0 && c-1>=0){
            if(vis[r-1][c-1] == 1) return false;
            r--;;
            c--;
        }

        return true;
    }

    String buildString(int pos,int n){
        String s = "";
        for(int i = 0;i<n;i++){
            if(i == pos){
                s+='Q';
            }else{
                s+='.';
            }
        }
        return s;
    }
}
