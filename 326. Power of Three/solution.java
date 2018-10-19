// 1162261467 是int型最大的3的次方，是19次方。因为3是质数，所以3的次方的因数都是3的次方，如果n能整除3^19，那么就说明是3的次方
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

// 还有一种用求对数的方法，换底公式(Math.log10(n) / Math.log10(3))
