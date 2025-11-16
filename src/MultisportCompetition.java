import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MultisportCompetition {

    // Класс участника
    public static class Participant {
        private String lastName;
        private String firstName;
        private int[] scores;

        public Participant(String lastName, String firstName, int s1, int s2, int s3, int s4) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.scores = new int[]{s1, s2, s3, s4};
        }

        public int getTotalScore() {
            return scores[0] + scores[1] + scores[2] + scores[3];
        }

        @Override
        public String toString() {
            return lastName + " " + firstName + " (" + getTotalScore() + " баллов)";
        }
    }

    // Основной метод
    public static void showTopParticipants(String filename) {
        List<Participant> participants = new ArrayList<>();

        // ======= ЧТЕНИЕ ФАЙЛА =======
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) continue;

                String[] parts = line.trim().split("\\s+");

                // Формат должен быть: Фамилия Имя Ч1 Ч2 Ч3 Ч4 → 6 элементов
                if (parts.length != 6) {
                    System.out.println("Неверный формат строки: " + line);
                    continue;
                }

                String last = parts[0];
                String first = parts[1];

                try {
                    int s1 = Integer.parseInt(parts[2]);
                    int s2 = Integer.parseInt(parts[3]);
                    int s3 = Integer.parseInt(parts[4]);
                    int s4 = Integer.parseInt(parts[5]);

                    participants.add(new Participant(last, first, s1, s2, s3, s4));

                } catch (NumberFormatException e) {
                    System.out.println("Ошибка чисел в строке: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        if (participants.isEmpty()) {
            System.out.println("Нет корректных данных.");
            return;
        }

        // ======= СОРТИРОВКА =======
        participants.sort((a, b) -> Integer.compare(b.getTotalScore(), a.getTotalScore()));

        // Находим TOP-3, учитываем одинаковые баллы
        int limit = Math.min(3, participants.size());
        int thresholdScore = participants.get(limit - 1).getTotalScore();

        List<Participant> winners = participants.stream()
                .filter(p -> p.getTotalScore() >= thresholdScore)
                .collect(Collectors.toList());

        // ======= ВЫВОД =======
        System.out.println("\n=== Лучшие участники многоборья ===");
        winners.forEach(System.out::println); // выводим всех
    }
}
