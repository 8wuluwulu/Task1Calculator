import java.util.*;

public class ProgrammerCalc {
    private static final Scanner scanner = new Scanner(System.in);
    private static int currentRadix = 10;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- ПРОГРАММНЫЙ КАЛЬКУЛЯТОР ---");
            System.out.println("1. Изменить систему счисления");
            System.out.println("2. Новое вычисление");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();
            if (choice.equals("0")) break;
            
            System.out.println("Функционал в разработке...");
        }
    }

    private static void StartCalculation() {
        try {
            System.out.print("Введите первое число: ");
            long num1 = Long.parseLong(scanner.nextLine(), currentRadix);
            System.out.print("Операция (+, -, *, /): ");
            String op = scanner.nextLine();
            System.out.print("Введите второе число: ");
            long num2 = Long.parseLong(scanner.nextLine(), currentRadix);

            long result = applyOp(op, num1, num2);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static long applyOp(String op, long a, long b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return 0;
        }
    }

    private static void selectRadix() {
        System.out.println("1. BIN, 2. OCT, 3. DEC, 4. HEX");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": currentRadix = 2; break;
            case "2": currentRadix = 8; break;
            case "4": currentRadix = 16; break;
            default: currentRadix = 10;
        }
    }

    private static String getRadixName(int radix) {
        if (radix == 2) return "Двоичная";
        if (radix == 16) return "Шестнадцатеричная";
        return "Десятичная";
    }
}