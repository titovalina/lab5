import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Задание 1.1
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(6, 8);
        System.out.println("Дробь f1: " + f1 + " = " + f1.toDouble());
        System.out.println("f1 равно f2? " + f1.equals(f2));

        // Задание 3.3
        List<Integer> L1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> L2 = Arrays.asList(2, 4, 6);
        List<Integer> merged = OrderedListMerger.merge(new ArrayList<>(L1), L2);
        System.out.println("Упорядоченный список: " + merged);

        // Задание 4.3
        MultisportCompetition.showTopParticipants("C:/Users/user/IdeaProjects/lab5/src/participants.txt");

        // Задание 5.7
        System.out.println("=== Буквы ===");
        SetTask setTask = new SetTask();
        int count = SetTask.countUniqueRussianLetters("C:/Users/user/IdeaProjects/lab5/src/text.txt");
        System.out.println("Уникальных русских букв: " + count);

        // Задание 6.2
        System.out.println("\n=== Очередь ===");
        QueueTask queueTask = new QueueTask();
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Queue<Integer> q = QueueTask.buildQueue(list);
        System.out.println("Очередь: " + q);

        // Задание 7.1
        System.out.println("\n=== 7.1 ===");
        List<Point> pts = List.of(
                new Point(1, -2),
                new Point(1, -2),
                new Point(3, 4),
                new Point(2, -5)
        );
        Polyline poly = StreamPolylineTask.createPolyline(pts);
        System.out.println(poly);

        // Задание 7.2
        System.out.println("\n=== 7.2 ===");
        Map<Integer, List<String>> names =
                StreamNamesTask.processNames("C:/Users/user/IdeaProjects/lab5/src/names.txt");
        System.out.println(names);
    }
}
