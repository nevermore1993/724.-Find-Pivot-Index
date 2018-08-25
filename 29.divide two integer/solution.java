// use bits operation to perform division, but dont consider all the corner cases, like -2`31, 2`31 - 1

class Solution {
    public int divide(int dividend, int divisor) {
        
        //int lengthS = getBits(divisor);
        int isDNeg = 0;
        int isSNeg = 0;
        int isMin = 0;
        if (dividend < 0) {
            dividend = 0 - dividend;
            isDNeg = -1;
        }
        int lengthD = getBits(dividend);
        if (divisor < 0) {
            divisor = 0 - divisor;
            isSNeg = -1; 
        }
        int quotient = 0;
        int remainder = 0;
        
        if (divisor == 1) {
            quotient = dividend;
            if ((isDNeg + isSNeg) == -1) {
                return -quotient;
            }  else 
                return quotient;
        }
            
        for (int i = lengthD - 1; i >= 0; i--) {
            remainder = (remainder << 1) + getBit(dividend, i);
            //System.out.println(remainder);
            if ((remainder - divisor) >= 0) {
                quotient = (quotient << 1) + 1;
                remainder = remainder - divisor;
            } else {
                quotient = (quotient << 1) + 0;
                remainder = remainder;
            }
            //System.out.println(remainder);
        }
        if ((isDNeg + isSNeg) == -1)
            return -quotient;
        else 
            return quotient;
        }
            
    }
    
    public int getBits(int num) {
        int i = 0;
        while(num != 0) {
            i++;
            num = num >> 1;
        }
        
        return i;
    }
    
    public int getBit(int num, int index) {
        int i = 1;
        if ((num & (i << index)) >> index == 1)
            return 1;
        else 
            return 0;
    }
}
