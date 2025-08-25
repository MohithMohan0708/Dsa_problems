class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(n == 1 && m == 1 && matrix[0][0] == target) return true;
        for(int i = 0; i < m; i++){
            int start = 0;
            int end = n-1;
            if((target >= matrix[i][start]) && (target <= matrix[i][end])){
                while(start<=end){
                    int mid = start+(end-start)/2;
                    if(matrix[i][mid] == target){
                        return true;
                    }
                    else if(matrix[i][mid] < target){
                        start = mid+1;
                    }
                    else{
                        end = mid-1;
                    }
                }
            }
            else{
                continue;
            } 
        }
        return false;
    }
}