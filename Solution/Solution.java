package Solution;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] testNumbers = {121, -121, 123, 0, 1221, 10, 11, 12321, 1001};
        for (int num : testNumbers) {
            System.out.println("Число " + num + " -> " + sol.isPalindrome(num));
        }
    }
}


// Задача: Перевірка паліндрому числа

// Напиши метод isPalindrome(int x), який перевіряє, чи є число x паліндромом.

// Правила:
// • Паліндром – це число, яке читається однаково зліва направо і справа наліво.
// • Всі від’ємні числа не паліндроми.
