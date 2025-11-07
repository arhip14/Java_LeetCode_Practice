package SearchinaBinarySearchTree;

public class SearchinaBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        // Створюємо BST:
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        SearchinaBinarySearchTree solution = new SearchinaBinarySearchTree();
        int valToSearch = 2;
        TreeNode result = solution.searchBST(root, valToSearch);

        if (result != null) {
            System.out.println("Subtree rooted at " + valToSearch + ":");
            printTree(result);
        } else {
            System.out.println("Value " + valToSearch + " not found in the BST.");
        }
    }

    private static void printTree(TreeNode node) {
        if (node == null) return;
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}

//You are given the root of a binary search tree (BST) and an integer val.
//
//Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
//
//
//
//Example 1:
//
//
//Input: root = [4,2,7,1,3], val = 2
//Output: [2,1,3]
//Example 2:
//
//
//Input: root = [4,2,7,1,3], val = 5
//Output: []
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 5000].
//        1 <= Node.val <= 107
//root is a binary search tree.
//        1 <= val <= 107