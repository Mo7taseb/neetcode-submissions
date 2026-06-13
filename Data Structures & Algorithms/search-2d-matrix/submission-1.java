class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length - 1;
        while(left < matrix.length) {
            if(target >= matrix[left][0] && target <= matrix[left][right]) {
                int i = 0;
                int j = matrix[0].length-1;
                while(i <= j) {
                    int mid = (i + j)/2;
                    if(target == matrix[left][mid]) return true;
                    else if(target > matrix[left][mid]) {
                        i = mid + 1;
                    }
                    else {
                        j = mid - 1;
                    }
                }
                return false;
            }
            else {
                left++;
            }
        }
        return false;
    }
}
