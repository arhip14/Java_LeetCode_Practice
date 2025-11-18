package LetterCombinationsofaPhoneNumber;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, map, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String[] map, String digits, int index, StringBuilder current) {
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }

        for(char c : map[digits.charAt(index) - '0'].toCharArray()) {
            current.append(c);
            backtrack(result, map, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber solution = new LetterCombinationsofaPhoneNumber();

        String digits = "23";
        List<String> combinations = solution.letterCombinations(digits);

        System.out.println("Комбінації для цифр \"" + digits + "\": " + combinations);
    }
}

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//
//Example 1:
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//Example 2:
//
//Input: digits = "2"
//Output: ["a","b","c"]
//
//
//Constraints:
//
//        1 <= digits.length <= 4
//digits[i] is a digit in the range ['2', '9'].