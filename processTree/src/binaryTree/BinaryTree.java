package binaryTree;
class Node {  
	int  pid;  
	int ppid;
	String name;
	Node child;  
	Node brother;  

	Node(int pid, int ppid, String name) {
		//super();
		this.pid = pid;
		this.ppid = ppid;
		this.name = name;
	}
	Node() {
		//super();
		;
	}

	public void display() {  
		System.out.print(this.pid + "\t");  
	}  

	@Override  
	public String toString() {  
		// TODO Auto-generated method stub  
		return String.valueOf(pid);  
	}  
}  
public class BinaryTree {  
	private Node root = null;  

	public BinaryTree(int pid, int ppid, String name) {  
		root = new Node(pid,ppid,name);  
		root.child  = null;  
		root.brother = null;  
	}  
	public BinaryTree() {  
		root = new Node();  
	}  
	public String insert(int pid, int ppid, String name) {  
		String error = null;  
		Node node = new Node(pid, ppid,name);  
		if (root == null) {  
			root = node;  
			root.child  = null;  
			root.brother = null;  
		} else {  
			Node current = root;  
			Node parent = root;  
			while (true) {  
				if (current.ppid==ppid) { //have same father then go to the right side
					parent = current;  
					current = current.brother;  
					if (current == null) {  
						parent.child = node;  
						break;  
					}  
				} else if (current.pid ==ppid) { //have the father-son relation then go to the left side
					parent = current;  
					current = current.child;  
					if (current == null) {  
						parent.child = node;  
						break;  
					}  
				} else {  
					error = "having same value in binary tree";  
				}     
			} // end of while  
		}  
		return error;  
	}  
	/** 
	 * //中序遍历(递归)： 
	 *    1、调用自身来遍历节点的左子树 
	 *    2、访问这个节点 
	 *    3、调用自身来遍历节点的右子树 
	 */  
	public void inOrderTraverse() {  
		System.out.print("中序遍历:");  
		inOrderTraverse(root);  
		System.out.println();  
	}  

	private void inOrderTraverse(Node node) {  
		if (node == null)   
			return ;  

		inOrderTraverse(node.child);  
		node.display();  
		inOrderTraverse(node.brother);  
	}  

	/** 
	 * //前序遍历(递归)： 
	 *    1、访问这个节点 
	 *    2、调用自身来遍历节点的左子树 
	 *    3、调用自身来遍历节点的右子树 
	 */  
	public void preOrderTraverse() {  
		System.out.print("前序遍历:");  
		preOrderTraverse(root);  
		System.out.println();  
	}  

	private void preOrderTraverse(Node node) {  
		if (node == null)   
			return ;  

		node.display();  
		preOrderTraverse(node.child);  
		preOrderTraverse(node.brother);  
	}  

	/** 
	 * //后序遍历(递归)： 
	 *    1、调用自身来遍历节点的左子树 
	 *    2、调用自身来遍历节点的右子树 
	 *    3、访问这个节点 
	 */  
	public void postOrderTraverse() {  
		System.out.print("后序遍历:");  
		postOrderTraverse(root);  
		System.out.println();  
	}  

	private void postOrderTraverse(Node node) {  
		if (node == null)   
			return ;  

		postOrderTraverse(node.child);  
		postOrderTraverse(node.brother);  
		node.display();  
	}  
	public int getMinValue() {  
		Node current = root;  
		while (true) {  
			if (current.child == null)  
				return current.pid;  

			current = current.child;  
		}  
	}
		/** 
		 *  
		 * 得到后继节点，即删除节点的左后代 
		 */  
		private Node getSuccessor(Node delNode) {  
			Node successor = delNode;  
			Node successorParent = null;  
			Node current = delNode.brother;  

			while (current != null) {  
				successorParent = successor;  
				successor = current;  
				current = current.child;  
			}  

			//如果后继节点不是删除节点的右子节点时，  
			if (successor != delNode.brother) {  
				//要将后继节点的右子节点指向后继结点父节点的左子节点，  
				successorParent.child = successor.brother;  
				//并将删除节点的右子节点指向后继结点的右子节点  
				successor.brother = delNode.brother;  
			}  
			//任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点  
			successor.child = delNode.child;  

			return successor;  
		}  
}
	