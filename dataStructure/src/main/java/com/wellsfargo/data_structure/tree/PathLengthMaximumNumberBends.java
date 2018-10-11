package com.wellsfargo.data_structure.tree;

public class PathLengthMaximumNumberBends {

	private static Node root;
	
	static int len = 0, maxBends = -1;

	static class Node {
		int key;
		Node left;
		Node right;

		public Node(int key) {
			super();
			this.key = key;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "data." + key;
		}
	}

	static Node newNode(int key) {
		return new Node(key);
	}

	static void findMaxBendsUtil(Node node, char dir, int bends,  int soFar) {
		// Base Case
		if (node == null)
			return;

		// Leaf node
		if (node.left == null && node.right == null) {
			if (bends > maxBends) {
				maxBends = bends;
				len = soFar;
			}
		}

		// Left child is NULL
		else if (node.left == null) {
			if (dir == 'r') {
				findMaxBendsUtil(node.right, dir, bends,  soFar + 1);
			} else {
				findMaxBendsUtil(node.right, 'r', bends + 1,  soFar + 1);
			}
		}

		// Right child is NULL
		else if (node.right == null) {
			if (dir == 'l') {
				findMaxBendsUtil(node.left, dir, bends,  soFar + 1);
			} else {
				findMaxBendsUtil(node.left, 'l', bends + 1,  soFar + 1);
			}
		}
		// Having both left and right child
		else {
			if (dir == 'l') {
				findMaxBendsUtil(node.left, dir, bends,  soFar + 1);
				findMaxBendsUtil(node.right, 'r', bends + 1,  soFar + 1);
			} else {
				findMaxBendsUtil(node.right, dir, bends,  soFar + 1);
				findMaxBendsUtil(node.left, 'l', bends + 1,  soFar + 1);
			}
		}
	}

	static int findMaxBends(Node node) {
		if (node == null)
			return 0;
		 int bends = 0;
		

		// Call for left subtree of the root
		if (node.left != null)
			findMaxBendsUtil(node.left, 'l', bends,  1);

		// Call for right subtree of the root
		if (node.right != null)
			findMaxBendsUtil(node.right, 'r', bends,  1);

		// Include the root node as well in the path length
		len++;

		return len;
	}

	public static void main(String[] args) {
		root = newNode(10);
		root.left = newNode(8);
		root.right = newNode(2);
		root.left.left = newNode(3);
		root.left.right = newNode(5);
		root.right.left = newNode(2);
		root.right.left.right = newNode(1);
		root.right.left.right.left = newNode(9);

		System.out.println(findMaxBends(root) - 1);
	}
}
