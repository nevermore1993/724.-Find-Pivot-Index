//my solution, cant erase duplicate set yet
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                neg.add(nums[i]);
            else
                pos.add(nums[i]);
        }
        
        for (int m = 0; m < pos.size(); m++) {
            for(int n = 0; n < neg.size(); n++) {
                if (pos.get(m) > (0 - neg.get(n))) {
                    for (int p = n + 1; p < neg.size(); p++) {
                        if (pos.get(m) + neg.get(n) + neg.get(p) == 0) {
                            set.add(neg.get(n));
                            set.add(neg.get(p));
                            set.add(pos.get(m));
                            //System.out.println(set.get(0) + " " + set.get(1) + " " + set.get(2));
                            result.add(set);
                            System.out.println(result.get(1).get(0) + " " + result.get(1).get(1) + " " + result.get(1).get(2));
                            set.clear();
                        }
                    }
                } else {
                    for (int p = m + 1; p < pos.size(); p++) {
                        if (pos.get(m) + neg.get(n) + pos.get(p) == 0) {
                            set.add(neg.get(n));
                            set.add(pos.get(m));
                            set.add(pos.get(p));
                            //System.out.println(set.get(0) + " " + set.get(1) + " " + set.get(2));
                            result.add(set);
                            System.out.println(result.get(0).get(0) + " " + result.get(0).get(1) + " " + result.get(0).get(2));
                            set.clear();
                        }
                    }
                }
            }
        }
        
        return result;
    }
}




//accepted solution, sort first, use two pointer, begin and end, move towards each other for each iteration。
//对每一个元素，从剩下的数组中寻找两个可能的值，一个指向头b，一个指向尾e，如果b+e = sum； 说明匹配，将两个指针都内移，因为只移一个的话肯定不满足；
//如果b+e < sum; 说明需要更大的值，将左边的内移，右边的不动；如果 b+e > num;说明需要更小的值，将右边的内移，左边的不动。



class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if 
                        (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
    return res;
    }
}
