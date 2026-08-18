class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return ans(0,n,dp);
    }

    // bottom up recursion
    int ans(int s, int n, int[] dp){
        if(s > n){
            return 0;
        }

        if(s == n){
            dp[s] = 1;
            return 1;
        }

        if(dp[s] != 0) return dp[s];

        
        int ans1 = ans(s+1,n,dp);
        int ans2 = ans(s+2,n,dp);
        dp[s] = ans1 + ans2;
        return ans1 + ans2;
    }
}
