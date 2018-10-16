// 学会从不同角度思考问题，我只想到从右下角开始缩减矩阵，但是从左下角开始缩减矩阵更加合理而且简单。

// 从左下角开始，如果大于当前元素，则不可能在同一列，列加一，即将当前列去掉，只对剩下的进行查找。
// 如果小于当前元素，则不可能在同一行，行减一，即将当前行去掉，只对剩下的进行查找。
// 6ms
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            }
            
            if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}

// 如果当前行首或者列首大于target，则之后的行列都不会存在target，去除这些行列；从右下角开始,行列减一进行遍历，这些元素都是当前子矩阵的最大值，如果
// 小于target，则说明之前的矩阵不存在target，去除。
// 9ms
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int m = matrix.length - 1, n = matrix[0].length - 1, x = 0, y =  0;;
        
        if (n == -1)
            return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                m = i;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] > target) {
                n = i;
                break;
            }
        }
        
        for (int i = matrix.length - 1, j = matrix[0].length - 1; i >= 0 && j >= 0; i--) {
            if (matrix[i][j] <= target) {
                x = i;
                y = j;
                break;
            }
            j--;
        }
        
        for (int i = m; i >= x; i--) {
            for (int j = n; j >= 0; j--) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        
        for (int i = x; i >= 0; i--) {
            for (int j = n; j >= y; j--) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}
