// not finished yet
class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean[][] results = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1)
                        return true;
                    boolean b1 = false, b2 = false, b3 = false, b4 = false;
                    if (i - 1 >= 0)
                        b1 = getResult(i - 1, j, board, word, 1);
                    if (i + 1 < board.length)
                        b2 = getResult(i + 1, j, board, word, 1);
                    if (j - 1 >= 0)
                        b3 = getResult(i, j - 1, board, word, 1);
                    if (j + 1 < board[0].length)
                        b4 = getResult(i, j + 1, board, word, 1);
                    results[i][j] = b1 || b2 || b3 || b4;
                }
            }
        }
        
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                result = result || results[i][j];
            }
          }
        return result;
        }
    
    
    public boolean getResult(int i, int j, char[][] board, String word, int index) {
        if (index == word.length())
            return true;
        if (index == word.length() - 1 && board[i][j] == word.charAt(index))
            return true;
        if (board[i][j] == word.charAt(index)) {
            boolean b1 = false, b2 = false, b3 = false, b4 = false;
            if (i - 1 > 0)
                b1 = getResult(i - 1, j, board, word, index + 1);
            if (i + 1 < board.length)
                b2 = getResult(i + 1, j, board, word, index + 1);
            if (j - 1 > 0)
                b3 = getResult(i, j - 1, board, word, index + 1);
            if (j + 1 < board[0].length)
                b4 = getResult(i, j + 1, board, word, index + 1);
            return b1 || b2 || b3 || b4;
        }
        return false;
    }
}
