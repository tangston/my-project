package eventTest;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class EventTest extends JFrame implements ActionListener{
	JPanel mp=null;
	JButton jb1=null,jb2=null;
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		EventTest tst=new EventTest();
	}
	public EventTest(){
		mp=new JPanel();
		//以下初始化窗口布局与相关属性
		this.setTitle("按键改背景颜色");
		
		this.getContentPane().setBackground(Color.black);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗体大小
		this.setSize(1080,720  );
		//初始化按键名称
		jb1=new JButton("黑色");
		//注册监听jb1
		jb1.addActionListener(this);
		jb1.setActionCommand("aa");
		
		jb2=new JButton("红色");
		jb2.addActionListener(this);
		jb2.setActionCommand("ab");
		//添加部件
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		this.add(mp);
		
	}
	
	//处理事件发生后的执行的方法
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("aa"))
		{
			System.out.println("black button");
			mp.setBackground(Color.black);
		}else if(e.getActionCommand().equals("ab"))
		{
			System.out.println("red button");
			mp.setBackground(Color.red);
		}else 
			System.out.println("what the fuck");
		
	}
	
}
/*class MyPanel extends JPanel{
	public void paint(Graphics g){
		super.paint(g);
		
	}
}*/