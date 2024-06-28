import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    // https://leetcode.com/problems/find-median-from-data-stream/description/
    // solution https://leetcode.com/problems/find-median-from-data-stream/solutions/1330646/c-java-python-minheap-maxheap-solution-picture-explain-clean-concise/

    //second half of the sorted array
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // first half of the sorted array
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public FindMedianfromDataStream() {}

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) { // odd number of elements in the array
            return maxHeap.peek();
        } else { // even number of elements in the array because maxHeap.size() == minHeap.size()
            return (minHeap.peek() + maxHeap.peek()) / 2.0d;
        }

    }
}
