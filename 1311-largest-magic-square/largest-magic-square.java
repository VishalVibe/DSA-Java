class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m= grid.length ; 
        int n = grid[0].length;
        
        int[][] rowSum = new int[m][n+1];
        int[][] colSum = new int[m+1][n];
        int[][] diag1 = new int[m+1][n+1];
        int[][] diag2 = new int[m+1][n+1];

        for(int i=0 ; i< m ; i++){
            for(int j=0 ; j< n ; j++){
                rowSum[i][j+1] = rowSum[i][j] + grid[i][j];
                colSum[i+1][j] = colSum[i][j] + grid[i][j];
                diag1[i+1][j+1] = diag1[i][j] + grid[i][j];
                diag2[i+1][j] = diag2[i][j+1] + grid[i][j];
            }
        }

        for(int k = Math.min(m , n) ; k >= 2 ; k--){
            for(int r = 0 ; r+k <= m ; r++){
                for(int c = 0 ; c+k <= n ; c++){
                    int target = rowSum[r][c+k]  - rowSum[r][c];
                    boolean valid = true;
                    for(int i=0 ; i<k && valid ; i++){
                        int sum = rowSum[r+i][c+k] - rowSum[r+i][c];
                        if(sum != target){
                            valid = false;
                        }
                    }

                    for(int j = 0 ; j < k && valid ; j++){
                        int sum = colSum[r+k][c+j] - colSum[r][c+j];
                        if(sum != target) valid = false;
                    }

                    int d1 = diag1[r+k][c+k] - diag1[r][c];
                    int d2 = diag2[r+k][c] - diag2[r][c+k];

                    if(valid && d1 == target && d2 == target){
                        return k;
                    }
                }
            }
        }
        return 1;
    }
}