package tankWar;
import java.awt.*;
import javax.swing.*;

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
	public void drawTank(int x,int y,Graphics g,int direct,int colorType){
		switch(colorType)//判断坦克的类型
		{
		case 0:g.setColor(Color.cyan);	break;
		case 1:g.setColor(Color.green);	break;
		}
		//paint left rectango
		g.fill3DRect(x,y,5,30,false);
		//paint mid rectango
		g.fill3DRect(x+5,y+5,10,20,false);
		//paint right rectango
		g.fill3DRect(x+15,y,5,30,false);
		//paint circle
		g.fillOval(x+5, y+10, 10, 10);
		//paint line
		g.drawLine(x+10,y+15,x+10,y+40);
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
	}	
}