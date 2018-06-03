class Solution {
    public int maxArea(int[] height) {
    
    /**
    ** optimized solution with time complexity of O(n)
    **
    ** two pointers, start and end, move the shorter one each time. 
    int i, j, max, cur;
        int length = height.length;
        i = 0;
        j = length - 1;
        max = 0;
        
        while(i != j) {
            cur = Math.min(height[i], height[j]) * (j - i);
            if(cur > max)
                max = cur;
            if(height[i] < height[j]) {
                i++;
            } else
                j--;
        }
        
        return max;    
  }
}

The O(n) solution with proof by contradiction doesn't look intuitive enough to me. Before moving on, read the algorithm first if you don't know it yet.

Here's another way to see what happens in a matrix representation:

Draw a matrix where the row is the first line, and the column is the second line. For example, say n=6.

In the figures below, x means we don't need to compute the volume for that case: (1) On the diagonal, the two lines are overlapped; (2) The lower left triangle area of the matrix is symmetric to the upper right area.

We start by computing the volume at (1,6), denoted by o. Now if the left line is shorter than the right line, then all the elements left to (1,6) on the first row have smaller volume, so we don't need to compute those cases (crossed by ---).

  1 2 3 4 5 6
1 x ------- o
2 x x
3 x x x 
4 x x x x
5 x x x x x
6 x x x x x x

Next we move the left line and compute (2,6). Now if the right line is shorter, all cases below (2,6) are eliminated.

  1 2 3 4 5 6
1 x ------- o
2 x x       o
3 x x x     |
4 x x x x   |
5 x x x x x |
6 x x x x x x

And no matter how this o path goes, we end up only need to find the max value on this path, which contains n-1 cases.

  1 2 3 4 5 6
1 x ------- o
2 x x - o o o
3 x x x o | |
4 x x x x | |
5 x x x x x |
6 x x x x x x



class Solution {
    public int maxArea(int[] height) {
        /**
        ** easy solution with time complexity of O(n^2)
        **/
        
        /*int length = height.length;
        int i = 1;
        int j;
        int max = 0;
        int cur = 0;
        int maxH = 0, maxW = 0;
        for(; i < length; i++) {
            if(i >= 2 && height[i - 1] <= height[i - 2])
                continue;
            for(j = i + 1; j <= length; j++) {
                //System.out.println(height[i - 1] +" " + height[j - 1]);
                //System.out.println("minH = " + maxH);
                if(Math.min(height[i - 1], height[j - 1]) * (j - i) < max)
                    continue;
                cur = Math.min(height[i - 1], height[j - 1]) * (j - i);
                //System.out.println(cur);
                if(cur > max) {
                    maxH = Math.min(height[i - 1], height[j - 1]);
                    maxW = j - i;
                    max = cur;
                }
                    
            }
        }
        return max;*/
        
    
    /*public int size(int i, int j, int[] height) {
        int m;
        m = Math.min(height[i - 1], height[j - 1]);
        return (j - i) * m;
    }*/
}
