import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {
    public String reverseVowelsofaString(String s) {
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }
        char[] chars = s.toCharArray();
        int left =0;
        int right = s.length() - 1;
        while( left < right) {
            if (!vowels.contains(chars[left])) {
                left++;
                continue;
            }
            if (!vowels.contains(chars[right])) {
                right--;
                continue;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        ReverseVowelsofaString sol = new ReverseVowelsofaString();
        System.out.println(sol.
                reverseVowelsofaString("IceCreAm"));
        System.out.println(sol.
                reverseVowelsofaString("leetcode"));
    }
}



//Given a string s, reverse only all the vowels in the string and return it.
//
//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
//
//
//
//Example 1:
//
//Input: s = "IceCreAm"
//
//Output: "AceCreIm"
//
//Explanation:
//
//The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
//
//Example 2:
//
//Input: s = "leetcode"
//
//Output: "leotcede"
//
//
//
//Constraints:
//
//        1 <= s.length <= 3 * 105
//s consist of printable ASCII characters.