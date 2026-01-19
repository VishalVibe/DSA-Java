class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length , n = mat[0].length ; 
        int[][] prefix = new int[m+1][n+1];

        for(int i=0 ; i< m ; i++){
            for(int j=0 ; j<n ; j++){
                prefix[i+1][j+1] = prefix[i+1][j] + prefix[i][j+1] - prefix[i][j] + mat[i][j];
            }
        }

        int low = 0 , high = Math.min(m,n);

        while(low<high){
            int mid = (high + low+1)/2;
            if(existSquare(prefix , mid , threshold)){
                low = mid;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }

    private boolean existSquare(int[][] prefix , int k , int threshold){
        int m = prefix.length-1 , n = prefix[0].length-1 ;

        for(int i=0 ; i+k<= m ; i++){
            for(int j=0 ; j+k<= n ; j++){
                int sum = prefix[i+k][j+k] - prefix[i+k][j] - prefix[i][j+k] + prefix[i][j];
                if(sum<= threshold){
                    return true;
                }
            }
        }

        return false;
    }
}