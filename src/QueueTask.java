import java.util.*;

public class QueueTask {

    public static Queue<Integer> buildQueue(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();

        for (int x : list) queue.add(x);

        List<Integer> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        for (int x : reversed) queue.add(x);

        return queue;
    }

    @Override
    public String toString() {
        return "Задание QueueTask: очередь L + reverse(L)";
    }
}
