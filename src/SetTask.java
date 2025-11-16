import java.io.*;
import java.util.*;

public class SetTask {

    public static int countUniqueRussianLetters(String filename) {
        Set<Character> letters = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char c = Character.toLowerCase((char) ch);
                if (c >= 'а' && c <= 'я' || c == 'ё') {
                    letters.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        return letters.size();
    }

    @Override
    public String toString() {
        return "Задание SetTask: подсчёт уникальных русских букв";
    }
}
