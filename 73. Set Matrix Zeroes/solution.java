// first store row and colunm of all 0 in two sets, then manipulate the matrix
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        Set<Integer> row = new HashSet<>();
        Set<Integer> colunm = new HashSet<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    colunm.add(j);
                }
            }
        }
        for (Integer m : row) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[m][i] = 0;
        }
        for (Integer n : colunm) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][n] = 0;
        }
    }
}

// same idea as above one
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        Set<Integer> row = new HashSet<>();
        Set<Integer> colunm = new HashSet<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    colunm.add(j);
                }
            }
        }
        
        //Iterator<Integer> rowValue = row.iterator();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || colunm.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// save colunm and row in a boolean matrix
class Solution {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        
        boolean[] shouldZeroColumn = new boolean[width];
        boolean[] shouldZeroRow = new boolean[height];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // System.out.println("[" + i + "," + j + "]: " + matrix[i][j]);
                if (matrix[i][j] == 0) {
                    shouldZeroColumn[j] = true;
                    shouldZeroRow[i] = true;
                }
            }
        }
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (shouldZeroColumn[j] || shouldZeroRow[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
