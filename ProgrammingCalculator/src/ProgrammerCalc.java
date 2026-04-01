import java.util.*;

public class ProgrammerCalc {
    private static final List<String> history = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int currentRadix = 10;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- ПРОГРАММНЫЙ КАЛЬКУЛЯТОР ---");
            System.out.println("Текущая система: " + getRadixName(currentRadix));
            System.out.println("1. Изменить систему счисления");
            System.out.println("2. Новое вычисление");
            System.out.println("3. Показать историю");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": selectRadix(); break;
                case "2": StartCalculation(); break;
                case "3": showHistory(); break;
                case "0":
                    System.out.println("Выход из программы. До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
    
    // Заглушки, чтобы код компилировался
    private static void selectRadix() {}
    private static void StartCalculation() {}
    private static void showHistory() {}
    private static String getRadixName(int r) { return "DEC"; }
}