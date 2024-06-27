import java.util.Arrays;

public class KClosestPointsToOrigin {
    // https://leetcode.com/problems/k-closest-points-to-origin/description/
    // solution https://leetcode.com/problems/k-closest-points-to-origin/solutions/220235/java-three-solutions-to-this-classical-k-th-problem/

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin test = new KClosestPointsToOrigin();

        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;

        int[][] result = test.kClosest(points, K);

        System.out.println("The " + K + " closest points to the origin are:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}
