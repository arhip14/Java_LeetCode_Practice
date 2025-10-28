import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Jony", 18);
        ages.put("Bob", 20);
        ages.put("Kendy", 12);
        System.out.println("Ages Jony" + ages.get("Jony"));
        if (ages.containsKey("Bob")) {
            System.out.println("Bob is here");
        }
        for (String name : ages.keySet()) {
            System.out.println(name + " -> " + ages.get(name));
        }
    }
}

// Метод Що робить

// put(key, value) додає або змінює пару

// get(key) отримує значення за ключем

// containsKey(key) перевіряє, чи існує ключ

// remove(key) видаляє пару за ключем

// size() повертає кількість елементів

// isEmpty() перевіряє, чи мапа порожня

