// plus one at the end, consider all corner case, like 9 + 1 in the middle, and 9 at the beginning of the array, array needs 
// to expand for 1
class Solution {
    public int[] plusOne(int[] digits) {
        
        if (digits.length == 0)
            return new int[] {1};
        
        for (int i = digits.length - 1; i >= 0; i--) { 
            if (digits[i] + 1 == 10) {
                if (i == 0) {
                    digits[i] = 0;
                    int[] result = new int[1 + digits.length];
                    result[0] = 1;
                    System.arraycopy(digits, 0, result, 1, digits.length);
                    return result;
                } else {
                    digits[i] = 0;
                }     
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        return digits;
    }
}
