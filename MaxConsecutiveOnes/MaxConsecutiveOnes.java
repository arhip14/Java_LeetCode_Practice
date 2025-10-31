package MaxConsecutiveOnes;

public class MaxConsecutiveOnes {
    public int maxConsecutiveOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(solution.maxConsecutiveOnes(nums1, 2));
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(solution.maxConsecutiveOnes(nums2, 3));
    }
}


//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//
//
//
//        Example 1:
//
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//        Example 2:
//
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
//
//        Constraints:
//
//        1 <= nums.length <= 105
//nums[i] is either 0 or 1.
//        0 <= k <= nums.length