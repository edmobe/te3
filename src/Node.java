
public class Node {
	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
		right = null;
		left = null;
	}
	
	public int getValue() {
		return this.value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
		
	}
	
}
