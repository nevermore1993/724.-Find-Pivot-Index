// 用一个cache矩阵来保存以当前节点为起点的最长递增路径。然后循环遍历所有节点。虽然不同的路径起点可能会经过相同的节点，但是从那一个节点开始之后的路径
// 都是相同的，长度就是存在cache中的长度。这样也代表当前节点已经被访问过了。
// 难点就在于用一个 长度cache matrix来取代 visited matrix
// 其实就是一个dp算法
class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
            int m = matrix.length, n = matrix[0].length;
            int[][] cache = new int[m][n];
            int max = 1;
            for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }   
        return max;
    }
    
    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}
