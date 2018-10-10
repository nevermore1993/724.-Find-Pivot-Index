// 每一次 n&(n-1) 会将最后一个1顶掉
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}

// straight forward solution, get all the bits and calculate count
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        
        return count;
    }
}
