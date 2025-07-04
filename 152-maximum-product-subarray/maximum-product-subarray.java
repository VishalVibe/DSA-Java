class Solution {
    public int maxProduct(int[] nums) {
        int maxP = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for(int i=1 ; i< nums.length ; i++){
            int current = nums[i];

            if(current <0){
                int temp = minSoFar ; 
                minSoFar = maxSoFar;
                maxSoFar = temp;
            }

            maxSoFar = Math.max(current , current * maxSoFar);
            minSoFar = Math.min(current , current * minSoFar);
            maxP = Math.max(maxP , maxSoFar);

        }
        return maxP;
        


        
    }
}