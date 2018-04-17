package binaryTree;
class Node {  
	int  pid;  
	int ppid;
	String name;
	Node child;  
	Node brother;  

	public Node(int pid, int ppid, String name) {
		//super();
		this.pid = pid;
		this.ppid = ppid;
		this.name = name;
		this.brother=null;
		this.child=null;
	}
	public Node() {
		this.pid = 0;
		this.ppid = -1;
		this.name = "root";
		this.brother=null;
		this.child=null;
	}

	public void display() {  
		System.out.println("pid:"+this.pid+"\tppid:"+this.ppid+"\tname:"+this.name);  
	}  

	@Override  
	public String toString() {  
		// TODO Auto-generated method stub  
		return String.valueOf(pid);  
	}  
}  
public class BinaryTree {  
	private Node root = null;  
	private int flag=0;
	private int depth=0;
	public BinaryTree(int pid, int ppid, String name) {  
		root = new Node(pid,ppid,name);  
		root.child  = null;  
		root.brother = null;  
	}  
	public BinaryTree() {  
		root = new Node();  
		root.child  = null;  
		root.brother = null; 
	}  
	public String insert(int pid, int ppid, String name) {  
		String error = null;  
		Node node = new Node(pid, ppid,name);    
		/*if(node!=null)
			node.display();*/
			
		preOrderInsert(node);
		return "ok";
	} 
	private void preOrderInsert(Node node) {  
		preOrderInsert(this.root,node); 
		this.flag=0;		
	}  
	
	
	private void preOrderInsert(Node current, Node node) {
		// TODO 自动生成的方法存根
		if(current==null)
			{
			//System.out.println("empty"+this.getClass());
				return;
			}
		preOrderInsert(current.brother,node); 	
		
		
		preOrderInsert(current.child,node);  
		
		
	
		if(this.flag==0)
		{
			if(current.pid==node.ppid)
			{
				current.child=node;
				//System.out.println("insert son ok");
				this.flag=1;
			}
			else if(current.ppid==node.ppid)
			{
				current.brother=node;
				//System.out.println("insert brother ok");
				this.flag=1;
			}
			else 
				return;
		}
		
	}
	/** 
	 * //前序遍历(递归)： 
	 *    1、访问这个节点 
	 *    2、调用自身来遍历节点的左子树 
	 *    3、调用自身来遍历节点的右子树 
	 */  
	public void preOrderTraverse() {  
		//System.out.print("前序遍历:");  
		preOrderTraverse(root);  
		//System.out.println();  
	}  
	
	private void preOrderTraverse(Node node) {  
		if (node == null)   
			return ;  

		
		this.depth++;
		for(int i=2;i<=this.depth;++i)
		System.out.print("\t");
		node.display();  
		preOrderTraverse(node.child);  
		this.depth--;
		
		
		preOrderTraverse(node.brother);  
	}  

	
	
}
	