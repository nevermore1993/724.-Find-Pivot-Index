// forward, put smallest element at beginning first, not as good as backward, cuz it requires swap, backward dont have to do 
// swap.
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;        
        for (int i = 0; i < m; i++) {
            if (nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
                rearrange(nums2);
            }
        }
        System.arraycopy(nums2, 0, nums1, m, n);        
    }
    
    public void rearrange(int[] nums) {
        if (nums.length == 1) return;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp; 
            } else
                break;
        }
    }
    
    
}

// backward, put largest element at end first
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(i>-1 && j>-1)
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        while(j >-1)
            nums1[k--] = nums2[j--];
    }
}


