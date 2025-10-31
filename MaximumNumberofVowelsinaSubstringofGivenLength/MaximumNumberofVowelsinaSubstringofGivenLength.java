package MaximumNumberofVowelsinaSubstringofGivenLength;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofVowelsinaSubstringofGivenLength {

    public int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = 0;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        maxCount = count;

        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        MaximumNumberofVowelsinaSubstringofGivenLength solution = new MaximumNumberofVowelsinaSubstringofGivenLength();
        System.out.println(solution.maxVowels("abciiidef", 3)); // Output: 3
        System.out.println(solution.maxVowels("aeiou", 2));     // Output: 2
        System.out.println(solution.maxVowels("leetcode", 3));  // Output: 2
    }
}

//Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
//
//Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
//
//
//
//Example 1:
//
//Input: s = "abciiidef", k = 3
//Output: 3
//Explanation: The substring "iii" contains 3 vowel letters.
//Example 2:
//
//Input: s = "aeiou", k = 2
//Output: 2
//Explanation: Any substring of length 2 contains 2 vowels.
//        Example 3:
//
//Input: s = "leetcode", k = 3
//Output: 2
//Explanation: "lee", "eet" and "ode" contain 2 vowels.
//
//
//        Constraints:
//
//        1 <= s.length <= 105
//s consists of lowercase English letters.
//        1 <= k <= s.length