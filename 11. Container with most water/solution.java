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
