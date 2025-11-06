package PathSum;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int count = countPathsFromNode(root, targetSum);
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right , targetSum);
        return  count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        PathSum solution = new PathSum();
        int result = solution.pathSum(root, 8);
        System.out.println("Кількість шляхів із сумою 8: " + result);
    }
    private int countPathsFromNode(TreeNode node, long targetSum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == targetSum) count++;

        count += countPathsFromNode(node.left, targetSum - node.val);
        count += countPathsFromNode(node.right , targetSum - node.val);
        return count;
    }
}
//Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//
//The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
//
//
//
//Example 1:
//
//
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
//Example 2:
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 1000].
//        -109 <= Node.val <= 109
//        -1000 <= targetSum <= 1000