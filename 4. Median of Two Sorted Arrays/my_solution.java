class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1, size2, midpos, curpos;
        int cur1 = 0, cur2 = 0;
        boolean evenOrodd;
        List<Integer> l;
        size1 = nums1.length;
        size2 = nums2.length;
        evenOrodd = ((size1 + size2) % 2 == 0);
        
        l = makeArray(nums1, nums2);
        
        if(evenOrodd) {
            midpos = (size1 + size2) / 2;
            return (double) (((double) l.get(midpos) + (double) l.get(midpos - 1)) / 2); 
        }  
        else {
            midpos = (size1 + size2) / 2;
            return (double) l.get(midpos);
        }
           
    }
    
    public List<Integer> makeArray(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();
        int cur1 = 0, cur2 = 0;
        while (cur1 < nums1.length || cur2 < nums2.length) {
            if (cur1 == nums1.length) {
                l.add(nums2[cur2]);
                cur2++;
            } else if (cur2 == nums2.length) {
                l.add(nums1[cur1]);
                cur1++;
            } else {
                if (nums1[cur1] < nums2[cur2]) {
                    l.add(nums1[cur1]);
                    cur1++;
                } else {
                    l.add(nums2[cur2]);
                    cur2++;
                }
            }
        }
        return l;
    }
}


// binary search solution, divide A and B into two parts, find the median  
// https://leetcode.com/articles/median-of-two-sorted-arrays/#
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
