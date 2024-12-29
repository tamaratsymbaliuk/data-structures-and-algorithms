import java.util.PriorityQueue;

public class QueuePractice {

    public static void main(String[] args) {
       int one = 1;
       int three = 3;


        PriorityQueue queue = new PriorityQueue();
        queue.offer(three);
        queue.offer(one);
        System.out.println(queue.peek()); // 1

    }

}
