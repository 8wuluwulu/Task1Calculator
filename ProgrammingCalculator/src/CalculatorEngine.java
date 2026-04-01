public class CalculatorEngine {
    public long applyOp(String op, long a, long b) {
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
            default: throw new IllegalArgumentException("Неверная операция.");
        }
    }
}
