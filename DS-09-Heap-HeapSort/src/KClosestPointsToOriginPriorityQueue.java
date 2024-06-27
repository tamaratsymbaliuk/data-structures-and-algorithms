import java.util.PriorityQueue;

public class KClosestPointsToOriginPriorityQueue {
    // solution using Priority Queue https://leetcode.com/problems/k-closest-points-to-origin/solutions/220235/java-three-solutions-to-this-classical-k-th-problem/


    // add - > O (log n) - n is the current number of elements in priority queue
    // peek -> O(1)
    // poll -> O(log n)
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);

        int n = points.length;
        for (int i = 0; i < n; i++) { // n iterations
            pq.add(points[i]); // each iteration works in O (log n)
                              // log(1) + log(2) + log(3) + ...+ log(n)    <= n * log n
        } // this for loop is n log n
        int[][] results = new int[K][2];
        for (int i = 0; i < K; i++) {
            results[i] = pq.poll();
        }
        return results;
    }

}
