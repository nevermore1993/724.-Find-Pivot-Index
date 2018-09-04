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
