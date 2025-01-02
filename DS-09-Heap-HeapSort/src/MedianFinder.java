import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> ordered = new PriorityQueue<>();
    PriorityQueue<Integer> sorted = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {}

    void addNum(int num) {
        ordered.offer(num);
        sorted.offer(num);

    }

    double findMedian() {
           return ordered.peek() + sorted.peek() / 2.0d;
        }
    }

