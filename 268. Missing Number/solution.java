// 应该出现的数是从0-nums.length，用他的和减去实际的和，就得到结果
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + i - nums[i];
        }
        return sum + nums.length;
    }
}

// 利用异或，相同的数异或的结果为0，那么nums中出现的数就会被异或为0，没有出现的数就会剩下。原理跟减去出现的数是一样的，只不过用位运算更高效。
class Solution {
    public int missingNumber(int[] nums) {
        int missingNum = 0;

        for (int i = 0; i < nums.length; i += 1) {
            missingNum = missingNum ^ nums[i] ^ i;
        }

        // i = nums.length is not involved in the for loop.
        missingNum = missingNum ^ nums.length;

        return missingNum;
    }
}

