// find the heightest bar, divide array into two parts, find the heightest bar in left part, water can be trapped between these 
// two bars, repeat for the rest left parts. do the same on right part. get the result by using new array minus original array

class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int result = 0;
        int max = 0;
        int[] temp = new int[height.length];
        System.arraycopy(height, 0, temp, 0, height.length);
    
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[max])
                max = i;
        }
        fillLeft(temp, max);
        fillRight(temp, max);
        
        for (int i = 0; i < height.length - 1; i++) {
            result = result + temp[i] - height[i];
        }
        return result;
    }
    
    public void fillLeft(int[] temp, int end) {
        int max = 0;
        if (end <= 1 )
            return;
        for (int i = 0; i < end; i++) {
            if (temp[i] > temp[max])
                max = i;
        }
        for (int i = max; i < end; i++) {
            temp[i] = temp[max];
        }
        fillLeft(temp, max);
    }
    
    public void fillRight(int[] temp, int start) {
        int max = temp.length - 1;
        if (start >= temp.length - 2 )
            return;
        for (int i = temp.length - 1; i > start; i--) {
            if (temp[i] > temp[max])
                max = i;
        }
        for (int i = start + 1; i <= max; i++) {
            temp[i] = temp[max];
        }
        fillRight(temp, max);
    }
}
