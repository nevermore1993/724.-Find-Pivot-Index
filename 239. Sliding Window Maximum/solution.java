// 开始我以为是要返回和最大的window。只用计算每次slide时产生的差值，就能知道这一次slide是否增大了和。如当前的起点是i，这这次slide产生的差值是
// nums[i + k - 1] - nums[i - 1], 即新覆盖的值减去被去掉的值 + 之前的diff。如果大于0，说明增大了，更新max（最大和的window的起点index），diff。
// 这样不用每次都计算window中所有数的和
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = 0, diff = 0;
        int res = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res += nums[i];   
        }
        result.add(res);
        for (int i = 1; i < nums.length; i++) {
            if (i + k - 1 >= nums.length) {
                break;
            }
            diff += (nums[i + k - 1] - nums[i - 1]);
            if (diff >= 0) {
                max = i;
                res += diff;
                result.add(res);
                diff = 0;
            }
        }
        
        return res;
    }
}

// 结果是要返回每个window中的最大值
For Example: A = [2,1,3,4,6,3,8,9,10,12,56], w=4

    partition the array in blocks of size w=4. The last block may have less then w.
    2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|

    Traverse the list from start to end and calculate max_so_far. Reset max after each block boundary (of w elements).
    left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56

    Similarly calculate max in future by traversing from end to start.
    right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56

    now, sliding max at each position i in current window, sliding-max(i) = max{right_max(i), left_max(i+w-1)}
    sliding_max = 4, 6, 6, 8, 9, 10, 12, 56
    
 // 在一个window中，left_max[i + k - 1]是移动后新加元素中最大的值，之所以要在分界处重新计算最大值，是因为移动后nums[i -1]不会再影响最大值
 // 所以在分界处重新计算最大值。而right_max[i]则是移动之前window中除去nums[i -1]的最大值，比较两者，就能得到当前window的最大值。
 // 之所以需要left和right来比较得到最大值，就是因为移动后可能会把本来最大的值剃掉，则left_max[i + k -1]就不能再保存之前的最大值了，
 // 之前的最大值用right_max来保存。
 // 也就是说 right_max[i]保存的是移动之前window中除去nums[i -1]的最大值，left_max[i+k-1]保存的是移动后新加入的元素的最大值。
 // 因为初始是前k个元素组成一个window，那么第一次移动时，k+1的元素就应该是新加入的元素的最大值，所以在k+1处要更新最大值，也就造成了分界。
 
class Solution {
    public static int[] slidingWindowMax(final int[] in, final int w) {
      final int[] max_left = new int[in.length];
      final int[] max_right = new int[in.length];

      max_left[0] = in[0];
      max_right[in.length - 1] = in[in.length - 1];

      for (int i = 1; i < in.length; i++) {
          max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

          final int j = in.length - i - 1;
          max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
      }

      final int[] sliding_max = new int[in.length - w + 1];
      for (int i = 0, j = 0; i + w <= in.length; i++) {
        sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
      }

      return sliding_max;
  }
}


// 利用deque（双端队列）来按顺序存储每个window中的从大到小的元素。移动后的操作：先将队头超出window范围的元素都去掉，队头的元素是最大的。然后
// 从队尾开始，将所有小于新元素的元素都去掉，将新元素插在队尾。然后如果队头的元素已经是第一个window的尾了，就将这个元素加入结果中。
// 我实现时的难点就是如果移动时被去掉的元素是原本最大的元素，则需要重新比较新window中的所有元素大小。利用deque后，会将之前window的元素
// 从大到小保存下来，而且deque中总是存在至少一个元素（k > 1时）。存在一个元素的情况是新加入的元素是最大的，会把deque之前所有的元素都挤掉，但是这种
// 情况时，下一次移动并不会因为这个元素越界而将这个最大值去掉，因为是刚加入的新元素，所以不存在问题。
// 利用双端队列的原因是，移动时，要将越界的最大值剔除（在队头），而要将新元素插入队尾，所以要一个能够对头尾操作的数据结构。
// stack只能对一端进行操作，所以不符合要求

public int[] maxSlidingWindow(int[] a, int k) {		
	if (a == null || k <= 0) {
		return new int[0];
	}
	int n = a.length;
	int[] r = new int[n-k+1];
    int ri = 0;
	// store index
	Deque<Integer> q = new ArrayDeque<>();
	for (int i = 0; i < a.length; i++) {
		// remove numbers out of range k
		while (!q.isEmpty() && q.peek() < i - k + 1) {
			q.poll();
		}
		// remove smaller numbers in k range as they are useless
		while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
			q.pollLast();
		}
		// q contains index... r contains content
		q.offer(i);
		if (i >= k - 1) {
			r[ri++] = a[q.peek()];
		}
	}
	return r;
}
