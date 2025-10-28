public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int k = solution.removeElement(nums, val);

        System.out.println("k = " + k);
        System.out.print("nums = [");
        for (int i = 0; i < nums.length; i++) {
            if (i < k)
                System.out.print(nums[i]);
            else
                System.out.print("_");
            if (i < nums.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
