package eventTest;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Demo extends JFrame {
	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Demo demo=new Demo();
		
	}
	
	public Demo(){
		mp=new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(300, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

class MyPanel extends JPanel implements KeyListener{
	int x=10,y=10;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillOval(x ,y, 10, 10);
	}
	//处理事件发生后的执行的方法
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y++;
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			y--;			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x--;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x++;
		}else ;
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
}