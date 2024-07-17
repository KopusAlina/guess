import java.util.Optional;
import java.util.Random;

public class Main {
    private static Optional<String> checkGuess(int guess) {
        if (guess < 1 || guess > 5) {
            throw new IllegalStateException();
        } else {
            int result = new Random().nextInt(5) + 1;
            System.out.println(result);
            if (result == guess) {
                return Optional.of("Поздравляем! Вы угадали значение!");
            } else {
                return Optional.empty();
            }
        }
    }

    public static void main(String[] args) {
        int guess = 3; // Пример догадки
        try {
            Optional<String> result = checkGuess(guess);
            result.ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Не угадали, попробуйте снова.")
            );
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

}