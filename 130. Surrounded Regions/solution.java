// start with all 'O' on the border, visit all connected 'O', keep a flag matrix to store index of all visited element.
// flip all 'O' that is not visited
// optimize solution, use original matrix to store visited 'O', just set it to a different char, say '1', then flip all 'O' to 'X', then 
// flip all '1' back to 'O'
class Solution {
    public void solve(char[][] board) {
        if (board.length <= 1 || board[0].length == 1)
            return;
        
        int[][] flag = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            if (i == 0) {
                for (int j = 1; j < board[0].length - 1; j++) {
                    if (board[i][j] == 'O')
                        connected(board, flag, i + 1, j);
                }
            } else if (i == board.length - 1) {
               for (int j = 1; j < board[0].length - 1; j++) {
                    if (board[i][j] == 'O')
                        connected(board, flag, i - 1, j);
                } 
            }else {
                if (board[i][0] == 'O')
                    connected(board, flag, i, 1);
                if (board[i][board[0].length - 1] == 'O')
                    connected(board, flag, i, board[0].length - 2);
            }
        }
        
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O' && flag[i][j] != 1)
                    board[i][j] = 'X';
            }
        }
        return;
    }
    
    public void connected(char[][] board, int[][] flag, int x, int y) {
        if (x < board.length - 1 && x > 0 && y < board[0].length - 1 && y > 0 && flag[x][y] != 1) {
            if (board[x][y] == 'O')
                flag[x][y] = 1;
            else
                return;
        } else
            return;
        connected(board, flag, x + 1, y);
        connected(board, flag, x - 1, y);
        connected(board, flag, x, y + 1);
        connected(board, flag, x, y - 1);
    }
}
