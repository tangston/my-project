package tankWar;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class TankGame extends JFrame
{
	MyPanel mp=null;
	public static void main(String[] args)
	{
		TankGame demo=new TankGame();
	}
	public TankGame(){
		mp=new MyPanel();
		this.add(mp);
		this.setSize(1080,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class MyPanel extends JPanel{
	//define my tank 
	Hero hero=null;
	public MyPanel(){
		hero=new Hero(10,10);
	}
	public void drawTank(int x,int y,Graphics g,int direction,int colorType){
		switch(colorType)//判断坦克的类型
		{
		case 0:g.setColor(Color.cyan);	break;
		case 1:g.setColor(Color.green);	break;
		}
		
		
		switch(direction)
		{
		case 0://画出向上的模型
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5,10, 20, false);
			g.fillOval(x+5, y+15, 10, 10);
			g.drawLine(x+10,y+15,x+10,y);
			break;
			
		case 1://画出向右的模型
			g.fill3DRect(x, y,30 , 5, false);
			g.fill3DRect(x, y+15,30 , 5, false);
			g.fill3DRect(x+5, y+5,20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15,y+10,x+30,y+10);
			break;
			
			
		case 2://画出向下的模型
			g.fill3DRect(x, y,30 , 5, false);
			g.fill3DRect(x, y+15,30 , 5, false);
			g.fill3DRect(x+5, y+5,20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+10,y+15,x+10,y+30);
			break;
			
			
		case 3://画出向左的模型
			g.fill3DRect(x, y,30 , 5, false);
			g.fill3DRect(x, y+15,30 , 5, false);
			g.fill3DRect(x+5, y+5,20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15,y+10,x,y+10);
			break;
		}
	
	}
	public void paint(Graphics g)//paint my tank
	{
		//init
		super.paint(g);
		g.fillRect(0,0,1080,720);
		this.drawTank(hero.getX(),hero.getY(), g, 0, 1);
		
	}
}
class Tank
{
	//tank's   coordinate
	int x=0,y=0;
	int direction=0;//0->3 is the up right down and left
	boolean isLive=true;
	int speed=1;
	int color=0;//enemy tank = 1,hero =0
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setColor(int color) {
		this.color=color;
	}

	public  int getColor() {
		return color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		this.setX(x);
		this.setY(y);
		this.setColor(0);
	}	
}