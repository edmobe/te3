import java.util.NoSuchElementException;

public class BinaryTree {
	private Node root;

	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public boolean contains(int value) {
		return this.contains(value, this.root);
	}

	private boolean contains(int value, Node current) {
		if (current == null) {
			return false;
		} else if (value < current.getValue()) {
			return contains(value, current.getLeft());
		} else if (value > current.getValue()) {
			return contains(value, current.getRight());
		} else {
			return true;
		}
	}

	public void insert(int value) {
		this.root = this.insert(value, this.root);
	}

	private Node insert(int value, Node current) {
		if (current == null) {
			return new Node(value);
		} else if (value < current.getValue()) {
			current.setLeft(this.insert(value, current.getLeft()));
		} else if (value > current.getValue()) {
			current.setRight(this.insert(value, current.getRight()));
		} else if (value == current.getValue()) {
			current.setAmount(current.getAmount() + 1);
		}
		return current;
	}

	public void delete(int value) {
		this.root = this.delete(value, this.root);
	}

	private Node delete(int value, Node current) {
		if (current == null) {
			throw new NoSuchElementException("Value not found in the binary tree.");
		} else if (value < current.getValue()) {
			current.setLeft(delete(value, current.getLeft()));
		} else if (value > current.getValue()) {
			current.setRight(delete(value, current.getRight()));
		} else {
			if (current.getAmount() > 1) {
				current.setAmount(current.getAmount() - 1);
			} else if (current.getLeft() == null || current.getRight() == null) {
				Node temp = null;
				temp = current.getLeft() == null ? current.getRight() : current.getLeft();

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successor = this.getSuccessor(current);
				current.setValue(successor.getValue());
				current.setAmount(successor.getAmount());
				current.setRight(this.deleteAll(successor.getValue(), current.getRight()));
				return current;
			}
		}
		return current;
	}

	public void deleteAll(int value) {
		this.root = deleteAll(value, this.root);
	}

	private Node deleteAll(int value, Node current) {
		if (current == null) {
			throw new NoSuchElementException("Value not found in the binary tree.");
		} else if (value < current.getValue()) {
			current.setLeft(deleteAll(value, current.getLeft()));
		} else if (value > current.getValue()) {
			current.setRight(deleteAll(value, current.getRight()));
		} else {
			if (current.getLeft() == null || current.getRight() == null) {
				Node temp = null;
				temp = current.getLeft() == null ? current.getRight() : current.getLeft();

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successor = this.getSuccessor(current);
				current.setValue(successor.getValue());
				current.setAmount(successor.getAmount());
				current.setRight(this.deleteAll(successor.getValue(), current.getRight()));
				return current;
			}
		}
		return current;
	}

	private Node getSuccessor(Node node) {
		Node temp = node.getRight();

		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}

		return temp;
	}

	public void print() {
		TreePrinter.print(this.root);
		System.out.println("\n" + "\n");
	}
}
