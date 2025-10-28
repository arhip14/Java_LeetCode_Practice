package Arrays.MergeSortedArray;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // індекс останнього елемента nums1
        int j = n - 1; // індекс останнього елемента nums2
        int k = m + n - 1; // індекс останнього елемента для злитого масиву

        // Зливаємо масиви, починаючи з кінця
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // Якщо залишилися елементи в nums2, копіюємо їх у nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        solution.merge(nums1, m, nums2, n);
        System.out.println(java.util.Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]
    }
}
