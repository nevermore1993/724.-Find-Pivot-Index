/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target) {
    int *result = (int *)malloc(3);
    int i;
    int j;
    int x;
    for(i = 0; i <= (numsSize -2); i++){
        x = target - nums[i];
        for(j = i + 1; j <= (numsSize - 1); j++){
            if(nums[j] == x){
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }
    return result;
}
