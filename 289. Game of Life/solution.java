// 要求变化同时产生，且in-place。所谓变化同时产生就是说不能先更新某些点，再根据这些点的更新值去更新剩下的点。但是判断时我们只能一个一个点去判断，
// 那么就需要记录下每个点变化后的值，和变化之前的值，而又要求in-place，那么可以将可能发生的两种变化 1 -> 0 0 -> 1 用另外两个数字来记录。
// 比如我在这里规定 1 -> 0 记为2， 0 -> 1 记为-1.
// 只要我们遇上这两个数字，我们就能知道这个点原来是什么值，在最后返回之前，也能根据这些值来判断变化之后是什么状态。
// 因为只有两种变化可能，并且状态之后两种，所以可以利用这种方法。
class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = liveNum(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2)
                        board[i][j] = 2;
                    else if (count > 3)
                        board[i][j] = 2;
                } else {
                    if (count == 3)
                        board[i][j] = -1;
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0;
                else if (board[i][j] == -1)
                    board[i][j] = 1;
            }
        }
    }
    
    public int liveNum(int[][] board, int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < board.length && i >= 0 && j < board[0].length && j >= 0) {
                    if (board[i][j] == 1 || board[i][j] == 2)
                        count++;
                }
            }
        }
        return (board[x][y] == 1) ? count - 1 : count;
    }
}
