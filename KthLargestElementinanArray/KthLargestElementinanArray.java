package KthLargestElementinanArray;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    public int kthLargestElementinanArray(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementinanArray solver = new KthLargestElementinanArray();

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(solver.kthLargestElementinanArray(nums1, k1)); // 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(solver.kthLargestElementinanArray(nums2, k2)); // 4
    }
}