import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAveragefromDataStream {
    Queue<Integer> q;
    int sum;
    int size;
    
    /** Initialize your data structure here. */
    public MovingAveragefromDataStream(int size) {
        q = new ArrayDeque<>();
        sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
       q.offer(val);
       sum += val;
       if (q.size() > size) {
           sum -= q.poll();
       }
       return (double) sum / q.size();
    }
}
