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
    
    // Временная заглушка
    private static void displayResult(long n1, String op, long n2, long res) {}
    
    // Заглушки, чтобы код компилировался
    private static void selectRadix() {}
    private static void showHistory() {}
    private static String getRadixName(int r) { return "DEC"; }
}