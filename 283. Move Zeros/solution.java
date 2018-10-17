// 在移动0的过程中会形成0的串，下次再移动的时候只交换0串的第一个和下一个非0的元素。记录下0串的头尾，O（n）时间复杂度
class Solution {
    public void moveZeroes(int[] nums) {
        int head = -1, tail = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (head == -1) {
                    head = i;
                    tail = i;
                } else {
                    tail++;   
                }
            } else if (nums[i] != 0 && head != -1){
                nums[head] = nums[i];
                nums[i] = 0;
                head++;
                tail++;
            }
        }
    }
}

// 记录遍历过程中非0元素的个数，因为存在0，所以非0元素的个数不可能大于当前遍历到的index，将对应个数位的元素写为新的，遍历结束后将非0个数之后的值都
// 置0，O（n）时间复杂度
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }
        while(index<nums.length){
            nums[index] = 0;
            index++;
        }
    }
}
