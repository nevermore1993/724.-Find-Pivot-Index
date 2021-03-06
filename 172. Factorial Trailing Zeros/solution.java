// 末尾0的个数就是指这个数总共有几个10因子，而10又能表示成2和5的乘积。假设m=n!，那么m中2的因子个数肯定大于5的因子个数，
// 所以m中5的因子个数即是所要求结果；
// 显然n除以5可得到1~n中包含有一个因子5的个数，但是，1~n中有的数可以被5整除好几次，所以必须将这个数再除以5，
// 得到1~n中包含有两个因子5的个数，依次循环进行累加即可得到全部5的因子个数；

class Solution {
    public int trailingZeroes(int n) {
        int count = n / 5;
        int i = 5;
        int f = count;
        while (f >= 5) {
            f /= 5;
            count += f;
        }
        return count;
    }
}
