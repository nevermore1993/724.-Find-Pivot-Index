// stupid solution
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            hs.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (hs.contains(board[i][j]))
                        return false;
                    else
                        hs.add(board[i][j]);
                }
            }
        }
        
        hs.clear();
        for (int i = 0; i < 9; i++) {
            hs.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (hs.contains(board[j][i]))
                        return false;
                    else
                        hs.add(board[j][i]);
                }
            }
        }
        
        hs.clear();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                hs.clear();
                for (int n = i; n < i + 3; n++) {
                    for (int m = j; m < j + 3; m++) {
                        System.out.println(board[n][m] != '.');
                        if (board[n][m] != '.') {
                            System.out.println(board[n][m]);
                            if (hs.contains(board[n][m]))
                                return false;
                            else
                                hs.add(board[n][m]);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}

// clever solution, combine three loop, using j/3 j%3 to locate cube element
public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}

// using string, format string based on element value and its location, add into set to see if its already exists
public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = board[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
}


// dont use set if u want to optimize speed.  use array to store count of each element, beats 97.5% of submission
class Solution {
    public boolean isValidSudoku(char[][] board) {
    int[] horizontal, vertical, cube;
	for (int i = 0; i < 9; i++) {
		horizontal = new int[9];
		vertical = new int[9];
		for (int j = 0; j < 9; j++) {
			int h = board[i][j]-'1';
			if (h>=0 && ++horizontal[h] >1) return false;
			int v = board[j][i]-'1';
			if (v>=0 && ++vertical[v] >1) return false;
		}
	}
	for (int i = 1; i <=7; i=i+3) {
		for (int j = 1; j <= 7; j=j+3) {
			cube = new int[9];
			for (int r = -1; r <=1; r++) {
				for (int c = -1; c <= 1; c++) {
					int v = board[j+r][i+c]-'1';
				        if (v>=0 && ++cube[v] >1) return false;
				}
			}
		}
	}
	return true;
}
}
