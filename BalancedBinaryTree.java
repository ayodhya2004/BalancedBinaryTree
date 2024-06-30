package binarytree;

public class BalancedBinaryTree {
	TreeNode2 root;

	    // Constructor
	    public BalancedBinaryTree() {
	        root = null;
	    }

	    // Function to insert a node in the tree
	    public void insert(int val) {
	        root = insertRecursive(root, val);
	    }

	    // Recursive function to insert nodes in a balanced binary tree
	    private TreeNode2 insertRecursive(TreeNode2 left, int val) {
	        if (left == null) {
	            left = new TreeNode2(val);
	            return left;
	        }

	        if (val < left.val) {
	            left.left = insertRecursive(left.left, val);
	        } else if (val > left.val) {
	            left.right = insertRecursive(left.right, val);
	        }

	        // Update height
	        updateHeight(left);

	        // Check balance factor and perform rotations if necessary
	        int balance = getBalance(left);

	        // Left Left case
	        if (balance > 1 && val < left.left.val) {
	            return rightRotate(left);
	        }

	        // Right Right case
	        if (balance < -1 && val > left.right.val) {
	            return leftRotate(left);
	        }

	        // Left Right case
	        if (balance > 1 && val > left.left.val) {
	            left.left = leftRotate(left.left);
	            return rightRotate(left);
	        }

	        // Right Left case
	        if (balance < -1 && val < left.right.val) {
	            left.right = rightRotate(left.right);
	            return leftRotate(left);
	        }

	        return left;
	    }

	    // Function to update the height of a node
	    private void updateHeight(TreeNode2 left) {
	        if (left != null) {
	            int leftHeight = (left.left == null) ? 0 : TreeNode2.height;
	            int rightHeight = (left.right == null) ? 0 : TreeNode2.height;
	            TreeNode2.height = Math.max(leftHeight, rightHeight) + 1;
	        }
	    }

	    // Function to get the balance factor of a node
	    private int getBalance(TreeNode2 root2) {
	        if (root2 == null) {
	            return 0;
	        }
	        int leftHeight = (root2.left == null) ? 0 : TreeNode2.height;
	        int rightHeight = (root2.right == null) ? 0 : TreeNode2.height;
	        return leftHeight - rightHeight;
	    }

	    // Function to perform a right rotation
	    private TreeNode2 rightRotate(TreeNode2 y) {
	    	TreeNode2 x = y.left;
	    	TreeNode2 T2 = x.right;

	        // Perform rotation
	        x.right = y;
	        y.left = T2;

	        // Update heights
	        updateHeight(y);
	        updateHeight(x);

	        // Return new root
	        return x;
	    }

	    // Function to perform a left rotation
	    private TreeNode2 leftRotate(TreeNode2 x) {
	    	TreeNode2 y = x.right;
	    	TreeNode2 T2 = y.left;

	        // Perform rotation
	        y.left = x;
	        x.right = T2;

	        // Update heights
	        updateHeight(x);
	        updateHeight(y);

	        // Return new root
	        return y;
	    }


	    public void printInorder() {
	        System.out.print("Inorder traversal of binary tree: ");
	        printInorderRecursive(root);
	        System.out.println();
	    }


	    private void printInorderRecursive(TreeNode2 root) {
	        if (root != null) {
	            printInorderRecursive(root.left);
	            System.out.print(root.val + " ");
	            printInorderRecursive(root.right);
	        }
	    }
	}

