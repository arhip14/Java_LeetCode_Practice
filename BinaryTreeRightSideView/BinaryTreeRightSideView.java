package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> binaryTreeRightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0 , result);
        return result;
    }
    public void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(node.val);
        }

        dfs(node.right, level+1, result);
        dfs(node.left , level +1, result);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        List<Integer> rightView = solution.binaryTreeRightSideView(root);

        System.out.println("Right side view: " + rightView);
    }
}

//Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//
//
//        Example 1:
//
//Input: root = [1,2,3,null,5,null,4]
//
//Output: [1,3,4]
//
//Explanation:
//
//
//
//Example 2:
//
//Input: root = [1,2,3,4,null,null,null,5]
//
//Output: [1,3,4,5]
//
//Explanation:
//
//
//
//Example 3:
//
//Input: root = [1,null,3]
//
//Output: [1,3]
//
//Example 4:
//
//Input: root = []
//
//Output: []
//
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//        -100 <= Node.val <= 100