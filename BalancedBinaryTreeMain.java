package binarytree;

public class BalancedBinaryTreeMain {

	    public static void main(String[] args) {
	    	BalancedBinaryTree tree = new BalancedBinaryTree();
	        tree.insert(10);
	        tree.insert(5);
	        tree.insert(15);
	        tree.insert(3);
	        tree.insert(7);
	        tree.insert(12);
	        tree.insert(20);

	        tree.printInorder();
	    }
	}