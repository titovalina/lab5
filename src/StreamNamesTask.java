import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StreamNamesTask {

    public static Map<Integer, List<String>> processNames(String filename) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            lines = reader.lines().toList();
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        return lines.stream()

                .filter(s -> s.contains(":"))

                .map(s -> s.split(":"))

                .filter(parts -> parts.length == 2 && parts[1].matches("\\d+"))

                .map(parts -> new AbstractMap.SimpleEntry<>(
                        Integer.parseInt(parts[1]),
                        formatName(parts[0])
                ))

                .collect(Collectors.groupingBy(
                        AbstractMap.SimpleEntry::getKey,
                        Collectors.mapping(AbstractMap.SimpleEntry::getValue, Collectors.toList())
                ));
    }

    private static String formatName(String name) {
        name = name.trim().toLowerCase();
        return name.substring(0,1).toUpperCase() + name.substring(1);
    }

    @Override
    public String toString() {
        return "StreamNamesTask: группировка имён по номеру";
    }
}
