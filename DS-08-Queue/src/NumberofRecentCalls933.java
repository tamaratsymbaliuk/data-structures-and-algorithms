import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls933 {
    // https://leetcode.com/problems/number-of-recent-calls/description/

    Queue<Integer> q;
    public NumberofRecentCalls933() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}
