// recurion solution, go through every path, add 1 when reach end.
class Solution {
    static int result = 0;
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        forward(0, 0, m, n);
        return result;
        
    }
    
    public void forward(int x, int y, int m, int n) {
        if (x == m - 1 && y == n - 1) {
            result += 1;
            return;
        } else {
            if (x + 1 <= m - 1) {
                forward(x + 1, y, m, n);
            } 
            if (y + 1 <= n - 1) {
                forward(x, y + 1, m, n);
            }
        }
    }
}

// recursion 
class Solution {
    static int result = 0;
    public int uniquePaths(int m, int n) {
        return dp(m, n);   
    }
    public int dp(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 || n == 1)
            return 1;
        
        return dp(m - 1, n) + dp(m, n - 1);
    }
}

// real dynamic programming result[i][j] = result[i - 1][j] + result[i][j - 1], form the matrix in loop, not recursion
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 || n == 1)
            return 1;
        
        int[][] result = new int[m][n];
        result[0][0] = 1;
        for (int i = 0 ;i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = result[i][j];
                if (j - 1 >= 0)
                    temp += result[i][j - 1];
                if (i - 1 >= 0)
                    temp += result[i - 1][j];
                result[i][j] = temp;
            }
        }      
        return result[m - 1][n - 1];
    }
}
