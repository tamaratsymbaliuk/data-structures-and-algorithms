import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        int[][] classes = {{1,2}, {3,5},{2,2}};
        int extraStudents = 2;
        MaximumAveragePassRatio test = new MaximumAveragePassRatio();
        double result = test.maxAverageRatio(classes, extraStudents);
        System.out.println(result);

    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) ->
                Double.compare(b[0], a[0])
        );
        for (int[] c : classes) {
            double passes = c[0], totalStudents = c[1];
            maxHeap.offer(new double[] {profit(passes, totalStudents), passes, totalStudents});
        }
        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            double passes = top[1], totalStudents = top[2];
            maxHeap.offer(new double[] {profit(passes + 1, totalStudents + 1), passes + 1, totalStudents + 1});
            extraStudents--;
        }
        double ans = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            double passes = top[1], totalStudents = top[2];
            ans += passes / totalStudents;
        }
        return ans / classes.length;
    }

    double profit(double passes, double totalStudents) {
        return (passes + 1) / (totalStudents + 1) - passes / totalStudents; // difference between added student and original value
    }
}
