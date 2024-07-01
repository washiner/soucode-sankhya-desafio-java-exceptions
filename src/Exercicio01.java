import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Exercicio01 {

    public static void main(String[] args) {
        String filePath = "/Users/washiner/Documents/SoulCode/washiner.txt";
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Stream<String> lines = reader.lines();
            sum = lines.mapToInt(line -> {
                try {
                    return Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    throw new InvalidNumberFormatException("Formato de numero invalido: " + line);
                }
            }).sum();
        } catch (IOException e) {
            System.err.println("Arquivo nao encontrado -> : " + filePath);
            return;
        } catch (InvalidNumberFormatException e) {
            System.err.println(e.getMessage());
            return;
        }

        System.out.println("A soma dos números é: " + sum);
    }

    public static class InvalidNumberFormatException extends RuntimeException {
        public InvalidNumberFormatException(String message) {
            super(message);
        }
    }

    public static class FileNotFoundException extends RuntimeException {
        public FileNotFoundException(String message) {
            super(message);
        }
    }
}
