package demo3;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author tangstone
 *
 */
public class GuiDemo {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		T2Frame mjf=new T2Frame();
	}

}
class MyJFrame extends JFrame implements MouseListener{
	private JLabel lb;
	public MyJFrame() {
		//about label
		lb=new JLabel("the coordinary of mouse",JLabel.CENTER);//文本对齐方式
		lb.addMouseListener(this);//在标签上注册事件监听
		lb.setForeground(Color.lightGray);
		lb.setBackground(Color.blue);
		lb.setFont(new Font("微软雅黑", 20,20));
		lb.setOpaque(true); 
		//about frame
		this.addMouseListener(this);
		this.setSize(720, 720);//在面板上注册事件监听
		this.add(lb,BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getButton()==e.BUTTON1) {
			String text="clicked mouse 2 and coord is:"+e.getX()+','+e.getY();
			lb.setText(text);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
			
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
}
