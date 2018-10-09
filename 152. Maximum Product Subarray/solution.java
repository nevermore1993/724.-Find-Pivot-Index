// my straight forward solution, divide array by element 0, because its product of int, the absolute value of product is always
// getting greater while iteration. key point here is to find the first negetive element that makes temp negetive, divide temp
// by it will get a possible maximum positive result
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        
        int begin = 0, end = 0, max = Integer.MIN_VALUE, temp = 1;
        
        while (begin < nums.length) {
            if (end == nums.length) {
                begin++;
                temp = 1;
                end = begin;
            } else {
                if (nums[end] == 0) {
                    if (temp < 0) {
                        while (begin < end && nums[begin++] > 0)
                            temp /= nums[begin - 1];
                        if (begin - 1 < end - 1)
                            max = Math.max(temp / nums[begin - 1], max);
                        else
                            max = Math.max(0, max);
                        temp = 1;
                        begin = end + 1;
                        end = begin;
                    } else {
                        begin = end + 1;
                        end = begin;
                        temp = 1;
                    }
                } else {
                    temp = nums[end] * temp;
                    max = Math.max(temp, max);
                    end++;
                }
            } 
        }
        return max;
    }
}

// keep track of min value of previous subarray, compare with A[i], makes sure we get a contiguous array
public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
