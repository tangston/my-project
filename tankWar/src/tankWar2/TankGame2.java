package tankWar2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class TankGame2 extends JFrame
{
	MyPanel mp=null;
	public static void main(String[] args)
	{
		TankGame2 demo=new TankGame2();
	}
	public TankGame2(){
		//初始化坦克图形界面
		mp=new MyPanel();
		this.add(mp);
		this.setSize(1080,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		//注册事件监听
		this.addKeyListener(mp);		
		//启动画板自动刷新
		Thread t=new Thread(mp);
		t.start();
	}
}

class MyPanel extends JPanel implements Runnable,KeyListener{
	//define my tank 
	Hero hero=null;
	Vector<EnemyTank>ets=new Vector<EnemyTank>();
	int etsNumber=3;
	public void paint(Graphics g)//paint my tank
	{

		super.paint(g);
		g.fillRect(0,0,1080,720);
		this.drawTank(hero.getX(),hero.getY(), g, hero.direction, 1);
		//draw hero bullet
		if(hero.myBullet!=null&&hero.myBullet.isLive()) {
			g.draw3DRect(hero.myBullet.getX(), hero.myBullet.getY(),3,3, false);
			
		}
		for(int i=0;i<ets.size();++i) {
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g,  ets.get(i).direction, ets.get(i).getColor());
		}
	}
	public MyPanel(){
		hero=new Hero(10,10);	
		//make enemy Tank
		for(int i=0;i<etsNumber;++i) {
			EnemyTank et=new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setDirection(2);
			ets.add(et);
		}
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
			g.drawLine(x+10,y+25,x+10,y);
			break;

		case 1://画出向右的模型
			g.fill3DRect(x, y,30 , 5, false);
			g.fill3DRect(x, y+15,30 , 5, false);
			g.fill3DRect(x+5, y+5,20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15,y+10,x+30,y+10);
			break;


		case 2://画出向下的模型
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5,10, 20, false);
			g.fillOval(x+5, y+5, 10, 10);
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
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					this.repaint();
					}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		if(e.getKeyCode()==KeyEvent.VK_A) {
			this.hero.setDirection(3);
			this.hero.MoveToLeft();
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			this.hero.setDirection(2);
			this.hero.MoveToDown();
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			this.hero.setDirection(1);
			this.hero.MoveToRight();
		}
		if(e.getKeyCode()==KeyEvent.VK_W) {
			this.hero.setDirection(0);
			this.hero.MoveToUp();
		}
		if(e.getKeyCode()==KeyEvent.VK_J) {
			this.hero.fire();
		}
		this.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根

	}
}
class Bullet implements Runnable{
	private boolean isLive;
	//tank's   coordinate
	private 	int x=0,y=0;
	private 	int direction=0;//0->3 is the up right down and left
	private 	int speed=5;
	public Bullet(int x,int y,int direct) {
		this.x=x;
		this.y=y;
		this.direction=direct;
		this.isLive=true;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
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
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
			try {
				
				while(true) {
					Thread.sleep(10);
					switch(this.direction) {
					case 0:this.y-=this.speed;break;
					case 1:this.x+=this.speed;break;
					case 2:this.y+=this.speed;break;
					case 3:this.x-=this.speed;break;
					}
					System.out.println("x  "+this.x+"  y "+this.y);
					if(x<=0||y<=0||x>=1080||y>=720) {
						this.isLive=false;
						break;
					}
				}
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

	}

}
class Tank
{
	//tank's   coordinate
	int x=0,y=0;
	int direction=0;//0->3 is the up right down and left
	boolean isLive=true;
	int speed=50;
	int color=0;//enemy tank = 1,hero =0
	
	public Tank(int x,int y) {
		this.x=x;
		this.y=y;
	}
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
	Bullet myBullet=null;
	public void fire() {
		//create bullet
		switch(this.direction)
		{
		case 0:
			myBullet=new Bullet(this.x+10,this.y,0);
			break;

		case 1:
			myBullet=new Bullet(this.x+30,this.y+10,1);
			break;


		case 2:
			myBullet=new Bullet(this.x+10,this.y+30,2);
			break;


		case 3:
			myBullet=new Bullet(this.x,this.y+10,3);
			break;
		}
	
		Thread t=new Thread(myBullet);
		t.start();
	}
	public Hero(int x,int y)
	{
		super(x,y);
		this.setColor(0);
	}	
	public void MoveToRight() {
		this.x+=this.speed;
	}
	public void MoveToUp() {
		this.y-=this.speed;
	}
	public void MoveToDown() {
		this.y+=this.speed;
	}
	public void MoveToLeft() {
		this.x-=this.speed;
	}

}
class EnemyTank extends Tank{

	public EnemyTank(int x, int y) {
		super(x, y);
		this.setColor(1);
		// TODO 自动生成的构造函数存根
	}

}