// divide and conqure
class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                    if (mid + 1 > x/(mid + 1))
                        return mid;
                    left = mid + 1;
            }
         }
    }
}

// Newton's method    http://www.matrix67.com/blog/archives/361
class Solution {
    public int mySqrt(int x) {
        if (x == 1 && x == 0) 
            return x;
        double result = x;
        while ((result * result - x) > 0.5) {
            result = result / 2 + x / result / 2;
        }
        return (int)result;
    }
}
