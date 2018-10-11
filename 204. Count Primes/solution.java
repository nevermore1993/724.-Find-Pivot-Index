// 类似动态规划，到n的质数个数等于 n-1的质数个数加n是否是质数。可以优化，只判断 6k - 1 和6k + 1 的数，所有大于等于5的质数都可以表示成这样。
// 判断是否是质数，只用除到 n 的平方根就行，因为 如果n是合数，那么一定可以因式分解，两个因子必定一个大于sqrt（n），另一个小于sqrt（n），所以只用
// 判断一半
class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        if (n <= 3)
            return 1;
        if (n <= 5)
            return 2;
        if (n <= 6)
            return 3;
        
        int dp = 2;
        for (int i = 6; i <= n; i += 6) {
            dp += (isPrimes(i - 1) ? 1 : 0);
            if (i + 1 < n)
                dp += (isPrimes(i + 1) ? 1 : 0);
                
        }
        return dp;
    }
    
    public boolean isPrimes(int n) {
        int temp = (int) Math.sqrt(n);
        for (int i = 2; i <= temp; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

// best solution, 从前开始遍历，将所有具有当前元素因子的元素标记上，遍历结束后所有没有标记的就是质数
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}
