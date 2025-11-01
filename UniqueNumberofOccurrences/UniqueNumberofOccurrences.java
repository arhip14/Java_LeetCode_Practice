import java.util.*;

class UniqueNumberofOccurrences  {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : arr) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        Set<Integer> occurrences = new HashSet<>(countMap.values());

        return occurrences.size() == countMap.size();
    }

    public static void main(String[] args) {
        UniqueNumberofOccurrences solution = new UniqueNumberofOccurrences();

        int[] arr1 = {1, 2, 2, 1, 1, 3};
        System.out.println(solution.uniqueOccurrences(arr1)); // true

        int[] arr2 = {1, 2};
        System.out.println(solution.uniqueOccurrences(arr2)); // false

        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(solution.uniqueOccurrences(arr3)); // true
    }
}
//Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
//
//
//
//        Example 1:
//
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
//        Example 2:
//
//Input: arr = [1,2]
//Output: false
//Example 3:
//
//Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//Output: true
//
//
//Constraints:
//
//        1 <= arr.length <= 1000
//        -1000 <= arr[i] <= 1000