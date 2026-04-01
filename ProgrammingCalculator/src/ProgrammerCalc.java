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

    private static long applyOp(String op, long a, long b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                if (b == 0) throw new ArithmeticException("Деление на ноль невозможно.");
                return a / b;
            case "&": return a & b;
            case "|": return a | b;
            case "^": return a ^ b;
            case "<<": return a << b;
            case ">>": return a >> b;
            default: throw new IllegalArgumentException("Неверная операция.");
        }
    }

    private static void StartCalculation() {
        try {
            System.out.print("Введите первое число (" + getRadixName(currentRadix) + "): ");
            long num1 = Long.parseLong(scanner.nextLine(), currentRadix);
            System.out.print("Выберите операцию (+, -, *, /, &, |, ^, <<, >>): ");
            String op = scanner.nextLine();
            System.out.print("Введите второе число (" + getRadixName(currentRadix) + "): ");
            long num2 = Long.parseLong(scanner.nextLine(), currentRadix);

            long result = applyOp(op, num1, num2);
            displayResult(num1, op, num2, result);
        }
        catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void selectRadix() {
        System.out.println("Выберите систему счисления:");
        System.out.println("1. Двоичная (2)");
        System.out.println("2. Восьмеричная (8)");
        System.out.println("3. Десятичная (10)");
        System.out.println("4. Шестнадцатеричная (16)");
        System.out.print("Выбор: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1": currentRadix = 2; break;
            case "2": currentRadix = 8; break;
            case "3": currentRadix = 10; break;
            case "4": currentRadix = 16; break;
            default: System.out.println("Неверный выбор, оставляем текущую систему.");
        }
        System.out.println("Система переключена на : " + getRadixName(currentRadix));
    }

    private static String getRadixName(int radix) {
        switch (radix) {
            case 2: return "Двоичная";
            case 8: return "Восьмеричная";
            case 10: return "Десятичная";
            case 16: return "Шестнадцатеричная";
            default: return "Неизвестная";
        }
    }

    private static void displayResult(long num1, String op, long num2, long result) {
        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        System.out.println("HEX: " + Long.toHexString(result).toUpperCase());
        System.out.println("DEC: " + result);
        System.out.println("OCT: " + Long.toOctalString(result));
        System.out.println("BIN: " + Long.toBinaryString(result));
        System.out.println("================");

        String entry = String.format("[%s] %s %s %s = %s", 
                getRadixName(currentRadix), 
                Long.toString(num1, currentRadix), op, 
                Long.toString(num2, currentRadix), 
                Long.toString(result, currentRadix));
        history.add(entry);
    }

    private static void showHistory() {
        System.out.println("\n--- ИСТОРИЯ ОПЕРАЦИЙ ---");
        if (history.isEmpty()) System.out.println("Пусто");
        else history.forEach(System.out::println);
    }
}