class Solution {
    public boolean canPartition(int[] nums) {
        int[][] dp = new int[200][10001];
        for(int i=0 ; i<dp.length ; i++){
            Arrays.fill(dp[i] , -1);
        }
        int sum=0;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        else{
            int target = sum/2;
            return checkSum(nums.length-1 , nums , target , dp);
        }
    }
    private boolean checkSum(int i , int[] nums , int target , int[][] dp){
        if(i ==0){
            return target == nums[i];
        }
        if(target ==0){
            return true;
        }
        if(dp[i][target] != -1){
            if(dp[i][target] == 0){
                return false;
            }
            else{
                return true;
            }
        }
        boolean notTake = checkSum(i-1 , nums , target , dp);
        boolean take = false;
        if(target >= nums[i]){
            take = checkSum(i-1 , nums , target-nums[i] , dp);
        }
        if(take || notTake){
            dp[i][target] = 1;
            return true;
        }
        else{
            dp[i][target] = 0;
            return false;
        }
        
    }

}