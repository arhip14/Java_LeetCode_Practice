public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // знайшли target
            } else if (nums[mid] < target) {
                left = mid + 1; // рухаємося праворуч
            } else {
                right = mid - 1; // рухаємося ліворуч
            }
        }

        return left; // індекс вставки, якщо target не знайдено
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums1, 5)); // 2
        System.out.println(solution.searchInsert(nums1, 2)); // 1
        System.out.println(solution.searchInsert(nums1, 7)); // 4
        System.out.println(solution.searchInsert(nums1, 0)); // 0
    }
}
