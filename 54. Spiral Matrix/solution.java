// add elements per circle, state 0, 1, 2, 3 represente traverse right, down, left and up. take every condition in to 
// consideration
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList();
        if (matrix[0].length == 0)
            return new ArrayList();
        
        int lengthM = matrix.length;
        int lengthN = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        
        int tempLength = Math.min(lengthM, lengthN);
        int mid = (tempLength % 2) == 0 ? tempLength / 2 : (tempLength + 1) / 2; 
        for (int i = 0; i < mid; i++) {
            int m = i;
            int n = i;
            int state = 0;
            boolean isEnd = false;
            while (!isEnd) {
                result.add(matrix[m][n]);
                switch (state) {
                    case 0:
                        if (n + 1 <= lengthN - i - 1)
                            n++;
                        else {
                            if (m + 1 <= lengthM - i - 1) {
                                m++;
                                state = 1;
                            } else{
                                isEnd = true;
                                break;
                            }
                        }
                        break;
                    case 1:
                        if (m + 1 <= lengthM - i - 1) 
                            m++;
                        else {
                            if (n - 1 < i) {
                            isEnd = true;
                            break;
                        } else {
                                state = 2;
                                n--;
                            } 
                        }
                        break;
                    case 2:
                        if (n - 1 >= i)
                            n--;
                        else {
                            if (m - 1 > i) {
                                state = 3;
                                m--;
                            } else {
                            isEnd = true;
                            break;
                            }
                        }
                        break;
                    case 3:
                        if (m - 1 > i)
                            m--;
                        else {
                            isEnd = true;
                            break;
                        }
                        break;
                }
            }
        }
        return result;
    }
}


// layer by layer .same idea, but more subtle, using for loop for each traverse direction, use four flag to stand for top, left, roght, bot
// index of each layer
class Solution {
    public List < Integer > spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}
