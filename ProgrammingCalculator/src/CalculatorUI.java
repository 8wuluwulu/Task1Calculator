import java.util.Scanner;

public class CalculatorUI {
    private final Scanner scanner = new Scanner(System.in);
    private final CalculatorEngine engine = new CalculatorEngine();
    private final HistoryManager history = new HistoryManager();
    private int currentRadix = 10;

    public void run() {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": selectRadix(); break;
                case "2": StartCalcutaion(); break;
                case "3": history.showHistory(); break;
                case "0": System.out.println("Выход из программы. До свидания!"); return;
                default: System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- ПРОГРАММНЫЙ КАЛЬКУЛЯТОР ---");
        System.out.println("Текущая система: " + getRadixName(currentRadix));
        System.out.println("1. Изменить систему счисления");
        System.out.println("2. Новое вычисление");
        System.out.println("3. Показать историю");
        System.out.println("0. Выход");
        System.out.print("Выбор: ");
    }

    private void selectRadix() {
        System.out.println("1. BIN(2), 2. OCT(8), 3. DEC(10), 4. HEX(16)");
        System.out.print("Выбор: ");
        switch (scanner.nextLine()) {
            case "1" -> currentRadix = 2;
            case "2" -> currentRadix = 8;
            case "3" -> currentRadix = 10;
            case "4" -> currentRadix = 16;
            default -> System.out.println("Оставлена текущая система.");
        }
    }

    private void StartCalcutaion() {
        try {
            System.out.print("Введите первое число (" + getRadixName(currentRadix) + "): ");
            long num1 = Long.parseLong(scanner.nextLine(), currentRadix);
            System.out.print("Выберите операцию (+, -, *, /, &, |, ^): ");
            String op = scanner.nextLine();
            System.out.print("Введите второе число (" + getRadixName(currentRadix) + "): ");
            long num2 = Long.parseLong(scanner.nextLine(), currentRadix);

            long result = engine.applyOp(op, num1, num2);
            displayAndSaveResult(num1, op, num2, result);
            history.addEntry(currentRadix, getRadixName(currentRadix), num1, op, num2, result);
        }
        catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private String getRadixName(int radix) {
        return switch (radix) {
            case 2 -> "Двоичная";
            case 8 -> "Восьмеричная";
            case 10 -> "Десятичная";
            case 16 -> "Шестнадцатеричная";
            default -> "Неизвестная";
        };
    }

    private void displayAndSaveResult(long n1, String op, long n2, long res) {
        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        System.out.println("HEX: " + Long.toHexString(res).toUpperCase());
        System.out.println("DEC: " + res);
        System.out.println("OCT: " + Long.toOctalString(res));
        System.out.println("BIN: " + Long.toBinaryString(res));

        history.addEntry(currentRadix, getRadixName(currentRadix), n1, op, n2, res);
    }
}
