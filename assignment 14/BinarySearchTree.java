import java.util.Stack;

public class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public String search(int key) {
		Node p=root;
		while(true){
			if(p==null){
				return null;
			}else if(key==p.key){
				return p.data;
			}else if(key<p.key){
				p=p.left;
				continue;
			}else if(key>p.key){
				p=p.right;
				continue;
			}
		}
	}

	public boolean add(int key, String data) {
		if(root==null){
			root=new Node(key, data);
		}

		Node p=root;
		while(true){
			if(key<p.key){
				if(p.left==null){
					p.left=new Node(key, data);
					return true;
				}else{
					p=p.left;
					continue;
				}
			}else if(key>p.key){
				if(p.right==null){
					p.right=new Node(key, data);
					return true;
				}else{
					p=p.right;
					continue;
				}
			}else{
				return false;
			}
		}
	}

	public boolean delete(int key) {
		Node p = root;
		Node c = root;
		boolean LC = false;
		while(c.key != key){
			p = c;
			if(c.key>key){
				LC = true;
				c = c.left;
			}else{
				LC = false;
				c = c.right;
			}
			if(c ==null){
				return false;
			}
		}
		
		if(c.left==null && c.right==null){
			if(c==root){
				root = null;
			}
			if(LC ==true){
				p.left = null;
			}else{
				p.right = null;
			}
		}
		
		else if(c.right==null){
			if(c==root){
				root = c.left;
			}else if(LC){
				p.left = c.left;
			}else{
				p.right = c.left;
			}
		}
		else if(c.left==null){
			if(c==root){
				root = c.right;
			}else if(LC){
				p.left = c.right;
			}else{
				p.right = c.right;
			}
		}else if(c.left!=null && c.right!=null){
			
			Node s	 = Successor(c);
			if(c==root){
				root = s;
			}else if(LC){
				p.left = s;
			}else{
				p.right = s;
			}			
			s.right = c.right;
		}		
		return true;		
	}

	public Node Successor(Node dNode){
		Node s =null;
		Node sP =null;
		Node c = dNode.left;
		while(c!=null){
			sP = s;
			s = c;
			c = c.right;
		}

		if(s!=dNode.left){
			sP.right = s.left;
			s.left = dNode.left;
		}
		return s;
	}

	public void printTree() {
		if (root == null) {
			System.out.println("No nodes in this tree");
		} else {
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);
			while (!stack.empty()) {
				Node p = stack.pop();
				System.out.print(p);
				if (p.getLeft() != null || p.getRight() != null)
					System.out.print(" has");
				if (p.getLeft() != null) {
					System.out.print(" " + p.getLeft() + " on left");
					stack.push(p.getLeft());
				}
				if (p.getRight() != null) {
					System.out.print(" " + p.getRight() + " on right");
					stack.push(p.getRight());
				}
				System.out.println("");
			}
		}
	}

	public static void main(String[] args) {
		// Test case 1
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(9, "n1");
		tree.add(5, "n2");
		tree.add(10, "n3");
		tree.add(2, "n4");
		tree.add(7, "n5");
		tree.add(11, "n6");
		tree.add(1, "n7");
		tree.add(4, "n8");
		tree.add(3, "n9");
		tree.add(6, "n10");
		tree.add(8, "n11");
		tree.add(12, "n12");
		tree.printTree();

		// Test case 2
		System.out.println("Search " + 1);
		System.out.println("Result " + tree.search(1));

		System.out.println("Search " + 11);
		System.out.println("Result " + tree.search(11));

		System.out.println("Search " + 20);
		System.out.println("Result " + tree.search(20));


		// Test case 3
		System.out.println("Delete " + 6);
		tree.delete(6);
		tree.printTree();

		System.out.println("Delete " + 10);
		tree.delete(10);
		tree.printTree();

		System.out.println("Delete " + 5);
		tree.delete(5);
		tree.printTree();
	}

	private class Node {
		private int key;
		private String data;
		private Node right;
		private Node left;

		public Node(int key, String data) {
			this.key = key;
			this.data = data;
			this.right = null;
			this.left = null;
		}

		public int getKey() {
			return key;
		}

		public String getData() {
			return data;
		}

		public void addLeft(Node n) {
			left = n;
		}

		public void addRight(Node n) {
			right = n;
		}

		public void deleteRight() {
			right = null;
		}

		public void deleteLeft() {
			left = null;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void update(int key, String data) {
			this.key = key;
			this.data = data;
		}

		public String toString() {
			return "<" + key + ", " + data.toString() + ">";
		}
	}

}