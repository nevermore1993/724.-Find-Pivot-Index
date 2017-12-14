int findLengthOfLCIS(int* nums, int numsSize) {
    int max = 0;
    int curr;
    int i = 0, j = 0;
    while(i < numsSize) {
        curr = 1;
        for(j = i; j < numsSize; j++) {
            if(j == numsSize - 1)
                break;
            else if(nums[j] < nums[j + 1]) {
                curr++;
            }
            else
                break;
        }
        max = max < curr ? curr : max;
        i = j + 1;
    }
    return max;
}
