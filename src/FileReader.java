import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader { // класс для считывания файлов
    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории."); // фраза из задания (Считывание файлов)
            return null;
        }
    }
}
