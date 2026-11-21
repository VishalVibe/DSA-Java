class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length +1];
        Arrays.fill(dp , -1);
        int n= cost.length;
        return climb(n,cost , dp);
        
    }
    private int climb(int n, int[] cost , int[] dp){
        if(n <= 1){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int left = climb(n-1 , cost , dp) + cost[n-1];
        int right = climb(n-2 , cost , dp) + cost[n-2];

        return dp[n] = Math.min(left , right);


    }
}