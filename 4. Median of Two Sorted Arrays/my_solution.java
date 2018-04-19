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
