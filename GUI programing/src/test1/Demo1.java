package test1;
import javax.swing.*;
import java.awt.*;//abstract windows tool

public class Demo1 extends JFrame
{
	//定义组件
	
	JButton  jb[]=new JButton[5];//此处创建了五个空指针
	JSplitPane jsp;

	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根
		Demo1 demo=new Demo1();

	}
	public Demo1()
	{
		//创建组件
		/*String []word={"boy","girl","bird"};
		jList =new JList(word);*/
		jb[0]=new JButton("中部");//这里一直到下面才开始开辟内存有实际的对象
		jb[1]=new JButton("东部");
		jb[2]=new JButton("南部");
		jb[3]=new JButton("西部");
		jb[4]=new JButton("北部");
		
		//添加组件位置
		this.add(jb[0],BorderLayout.CENTER);
	//	this.add(jb[1],BorderLayout.EAST);
	//	this.add(jb[2],BorderLayout.SOUTH);
		this.add(jb[3],BorderLayout.WEST);
		this.add(jb[4],BorderLayout.NORTH);
		
		//窗体设置
		this.setVisible(true);
		this.setTitle("ts'边界布局例程序000");
		this.setSize(600,600);
		this.setLocation(200, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
