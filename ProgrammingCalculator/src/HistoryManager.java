import java.util.ArrayList;
import java.util.List;

public class HistoryManager {

    private final List<String> history = new ArrayList<>();

    public void addEntry(int radix, String radixName, long n1, String op, long n2, long result) {
        String entry = String.format("[%s] %s %s %s = %s",
                radixName,
                Long.toString(n1, radix), op,   
                Long.toString(n2, radix),
                Long.toString(result, radix));
        history.add(entry);
    }

    public void showHistory() {
        System.out.println("\n--- ИСТОРИЯ ОПЕРАЦИЙ ---");
        if (history.isEmpty()) System.out.println("Пусто");
        else history.forEach(System.out::println);
    }
    
}
