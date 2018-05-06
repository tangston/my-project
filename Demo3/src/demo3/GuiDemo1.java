package demo3;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*; 
public class GuiDemo1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		T2Frame mf=new T2Frame();
	}

}
class T2Frame extends JFrame{
	private JLabel jlb=new JLabel("habit");
	private JLabel jlb1=new JLabel("sex");
	private JPanel jp=new JPanel();
	private JCheckBox jcb1=new JCheckBox("sing");
	private JCheckBox jcb2=new JCheckBox("pingpong");
	private JCheckBox jcb3=new JCheckBox("badminton");
	private JRadioButton jrb=new JRadioButton("male");
	private JRadioButton jrb1=new JRadioButton("female");
	private JTextArea jta=new JTextArea();
	private JScrollPane jsp=new JScrollPane(jta);//滚动条里的文本
	public T2Frame() {
		//窗体
		this.setVisible(true);
		this.setSize(720, 1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//添加组件
		this.add(jp,BorderLayout.NORTH);		//建立画板   BorderLayout.NORTH
		this.add(jsp,BorderLayout.CENTER);
		//panel add its things
		jp.add(jlb);
		jp.add(jcb1);
		jp.add(jcb2);
		jp.add(jcb3);
		jp.add(jrb);
		jp.add(jrb1);
		
		
	}

}
