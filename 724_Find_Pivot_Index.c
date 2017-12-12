int pivotIndex(int* nums, int numsSize) {
    double total = 0;
    double curr = 0;
    
    for(int i = 0; i < numsSize; i++) {
        total = total + nums[i];
    }
    
    for(int i = 0; i < numsSize; i ++) {
        if(curr == (total - nums[i])/2)
            return i;
        else {
            curr = curr + nums[i];
        }
    }
    return -1;
}
