// 首先遍历数组，统计每个数字出现的次数，保存在hashmap中。
// 然后将hashmap中每个key，按照他们的value值(即出现的顺序)，按照从低到高的规则存放到优先队列中。
// 声明优先队列时要设置comparetor，这样当我们往队列中添加新的元素时，会按照我们设定的规则将该元素放入正确的位置。
// 这里(n1, n2) -> count.get(n1) - count.get(n2) 就是匿名内部类comparator的lambda表达式，如果n1小于n2的话则不换位，否则换位。
// 然后我们将hashmap中的值放入队列中，每当队列的大小超过k了，就弹出队首，即当前遍历到的出现次数最少的。这样保证了我们在添加过程中，
// 队列里保存的永远是当前最大的k个。遍历结束时，就得到了出现次数最大的k个。然后再依次取出，放入结果列表，再取反，因为是按照从低到高
// 的顺序取出的。
class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    // build hash map : character and how often it appears
    HashMap<Integer, Integer> count = new HashMap();
    for (int n: nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

    // keep k top frequent elements in the heap
    for (int n: count.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }

    // build output list
    List<Integer> top_k = new LinkedList();
    while (!heap.isEmpty())
      top_k.add(heap.poll());
    Collections.reverse(top_k);
    return top_k;
  }
}



// python实现就简单的多，思想类似，不过没有用到堆，而是用了排序。也可以使用大顶堆，heapq，只取前k个。
import collections
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dict1 = collections.Counter(nums)
        dict2 = sorted(dict1.items(),key = lambda x:x[1],reverse=True)
        res = []
        for i in range(k):
            res.append(dict2[i][0])
        return res
