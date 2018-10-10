// recursivly visited a connected island, mark visited element as 1 in visited matrix. Every time we spot a new 1 element which 
// has not been visited indicates that we have found a new island, count++.
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    helper(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void helper(char[][] grid, int[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (visited[i][j] == 1)
            return;
        if (grid[i][j] != '1')
            return;
        else
            visited[i][j] = 1;
        
        helper(grid, visited, i + 1, j);
        helper(grid, visited, i - 1, j);
        helper(grid, visited, i, j + 1);
        helper(grid, visited, i, j - 1);
    }
}
