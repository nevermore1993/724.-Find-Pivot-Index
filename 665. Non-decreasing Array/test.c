// 如果只有三个点，肯定有一种方法，只调整一个点，就形成一条直线，但是如果四个点，是有两个拐点的折线，且最后一个点比第二个点
// 要小，那么就不能只调整一个点了。
bool checkPossibility(int* nums, int numsSize) {
    int i = 0;
    int count = 0;
    for(; i < numsSize -1;) {
        if(nums[i] > nums[i + 1]) {
            if((i - 1) > -1 && (i + 2) < numsSize&& nums[i - 1] > nums[i + 1] && nums[i - 1] <= nums[i] && nums[i + 2] < nums[i])
                return false;
            else
                count++;
        }
        i++;
        if(count > 1)
            return false;  
    }
    return true;
}

nums[i - 1] > nums[i + 1] && nums[i - 1] <= nums[i] && 
(i - 1) > -1 && 

bool checkPossibility(int* nums, int numsSize) {
    int i = 0;
    int count = 0;
    for(; i < numsSize -1;) {
        if(nums[i] > nums[i + 1]) {
            if((i - 1) > -1 && (i + 2) < numsSize && nums[i - 1] > nums[i + 1] && nums[i + 2] < nums[i])
                return false;
            else
                count++;
        }
        i++;
        if(count > 1)
            return false;  
    }
    return true;
}
