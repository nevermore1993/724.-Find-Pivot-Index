// 可以利用普通的排序方法， 但是会超时。
// 用priority queue的好处是它底层是用堆实现的，可以直接获取其中的最大值（大顶堆）或者最小值（小顶堆）。
// 利用两个queue，大顶堆用来存小的一半数字，小顶堆用来存大的一半数字。每次添加的时候，根据最大最小值来判断加入到哪个queue里，而且保证大顶堆的大小
// 最多只比小顶堆大1，如果不符，就移动最大或者最小值到另外一个堆。最后根据总得长度来返回大顶堆的最大值或者mean of max and min
class MedianFinder {
    PriorityQueue<Integer> minHeap;//heap is a minimal heap by default
    PriorityQueue<Integer> maxHeap;//change to a maximum heap
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
	    minHeap.offer(maxHeap.poll());
	    if (maxHeap.size() < minHeap.size())
		    maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
		    return (maxHeap.peek() + minHeap.peek()) / 2.0;
	    else
		    return maxHeap.peek();
    }
}
