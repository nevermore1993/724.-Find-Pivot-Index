// binary search, just split the array into two parts, compare target and two end points to
// decide start and end index of the wanted subarray

class Solution {
    public int search(int[] nums, int target) {
    return binarySearch(nums,0,nums.length-1,target);
}

private int binarySearch(int[] nums, int left, int right, int target){
    if(left > right) return -1;
    int mid = (left + right)/2;
    if(target == nums[mid]) return mid;
    if(target > nums[mid]) {
        if(nums[mid] < nums[left] && target > nums[right]){
            return binarySearch(nums,left,mid-1,target);
        }else {
            return binarySearch(nums,mid+1,right,target);
        }
    }else{
        if(nums[mid] > nums[right] && target < nums[left]){
            return binarySearch(nums,mid+1,right,target);
        }else {
            return binarySearch(nums,left,mid-1,target);
        }
    }
}
}
