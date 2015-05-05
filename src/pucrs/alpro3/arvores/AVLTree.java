package pucrs.alpro3.arvores;


/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class AVLTree {

	private class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			left = right = null;
			count++;
		}
	}

	private Node root;
	private int count;

	public AVLTree() {
		root = null;
		count = 0;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return count;
	}

	public void add(int value) {
		root = add(root, value);
	}

	private Node add(Node node, int value) {
		if (node == null)
			return new Node(value);

		if (value < node.value)
			node.left = add(node.left, value);
		else if (value > node.value)
			node.right = add(node.right, value);
		else
			throw new RuntimeException("A chave já está cadastrada: " + value);

		return node;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		if (node == null)
			return false;

		if (value < node.value)
			return contains(node.left, value);

		if (value > node.value)
			return contains(node.right, value);

		return true;
	}

	public String toString() {
		return toString(root);
	}

	private String toString(Node node) {
		if (node == null)
			return "*";
		return node.value + " " + toString(node.left) + " "
				+ toString(node.right);
	}

	}