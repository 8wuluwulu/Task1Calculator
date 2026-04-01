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
}