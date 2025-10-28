public class Prefix_Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        Prefix_Solution sol = new Prefix_Solution();

        String[] test1 = {"flower", "flow", "flight"};
        System.out.println(sol.longestCommonPrefix(test1));

        String[] test2 = {"dog", "racecar", "car"};
        System.out.println(sol.longestCommonPrefix(test2));

        String[] test3 = {"interview", "internet", "internal"};
        System.out.println(sol.longestCommonPrefix(test3));

        String[] test4 = {"a"};
        System.out.println(sol.longestCommonPrefix(test4));

        String[] test5 = {"", "abc", "abcd"};
        System.out.println(sol.longestCommonPrefix(test5));
    }
}

/*
 * Умови для перевірки: 1. strs.length = 0 → повернути "" 2. strs містить тільки один рядок →
 * повернути цей рядок 3. Жодного спільного префікса → повернути "" 4. Деякий спільний префікс →
 * повернути його 5. Префікс рівний одному з рядків → правильно обробляється
 */
