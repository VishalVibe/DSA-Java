class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length ; 
        int n = mat[0].length ; 
        int maxSide = 0;
        int[][] rowSum = new int[m][n+1];
        int[][] colSum = new int[m+1][n];

        for(int i=0 ; i<m ; i++){
            for(int j = 0; j<n ; j++){
                rowSum[i][j+1] = rowSum[i][j] + mat[i][j];
                colSum[i+1][j] = colSum[i][j] + mat[i][j];

            }
        }

        for(int k = Math.min(m , n) ; k>0 ; k--){
            for(int r=0 ; r+k<=m ; r++){
                for(int c = 0 ; c+k <= n ; c++){
                    int sum = 0 ;
                    for(int i=0 ; i< k ; i++){
                        sum += rowSum[r+i][c+k] - rowSum[r+i][c];

                    }
                    if(sum <= threshold){
                        maxSide = Math.max(k , maxSide);
                    }
                }
            }
        }
        return maxSide;
    }
}