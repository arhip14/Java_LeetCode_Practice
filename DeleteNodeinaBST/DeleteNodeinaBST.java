package DeleteNodeinaBST;

public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public static void main(String[] args) {
        // Припускаємо, що клас TreeNode вже існує в проекті
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        DeleteNodeinaBST solution = new DeleteNodeinaBST();
        System.out.println("Original BST in-order:");
        printTree(root);
        System.out.println();

        int keyToDelete = 3;
        TreeNode newRoot = solution.deleteNode(root, keyToDelete);

        System.out.println("BST after deleting key " + keyToDelete + " in-order:");
        printTree(newRoot);
        System.out.println();
    }

    private static void printTree(TreeNode node) {
        if (node == null) return;
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}

//Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//
//Basically, the deletion can be divided into two stages:
//
//Search for a node to remove.
//If the node is found, delete the node.
//
//
//        Example 1:
//
//
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
//
//Example 2:
//
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
//Example 3:
//
//Input: root = [], key = 0
//Output: []
//

//Constraints:
//
//The number of nodes in the tree is in the range [0, 104].
//        -105 <= Node.val <= 105
//Each node has a unique value.
//root is a valid binary search tree.
//-105 <= key <= 105