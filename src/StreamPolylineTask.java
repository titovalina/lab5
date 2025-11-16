import java.util.*;
import java.util.stream.Collectors;

public class StreamPolylineTask {

    public static Polyline createPolyline(List<Point> points) {

        List<Point> cleaned = points.stream()
                // заменить отрицательные Y на положительные
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))

                // убрать дубликаты по X,Y
                .distinct()

                // сортировка по X
                .sorted(Comparator.comparing(Point::getX))

                .collect(Collectors.toList());

        return new Polyline(cleaned);
    }

    @Override
    public String toString() {
        return "StreamPolylineTask: обработка точек → Polyline";
    }
}
