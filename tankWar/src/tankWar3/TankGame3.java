package tankWar3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class TankGame3 extends JFrame
{
	MyPanel mp=null;
	public static void main(String[] args)
	{
		TankGame3 demo=new TankGame3();
	}
	public TankGame3(){
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
	Bullet bt=null;
	Image picture=null;
	Vector<Bomb>b=new Vector<Bomb>();
	public void paint(Graphics g)
	{
		
		super.paint(g);
		g.fillRect(0,0,1080,720);
		//paint my tank
		this.drawTank(hero.getX(),hero.getY(), g, hero.direction, 1);
		//draw hero bullet
		for(int i=0;i<hero.BS.size();++i) {
			bt=hero.BS.get(i);
			if(bt!=null&&bt.isLive()) {
				g.draw3DRect(bt.getX(), bt.getY(),3,3, false);
			}
			else hero.BS.remove(i);		
		}
		//paint enemy tank
		Thread t=null;
		for(int i=0;i<ets.size();++i) {
			if(ets.get(i).isLive) {
				t=new Thread(ets.get(i));
				t.start();
				this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g,  ets.get(i).direction, 0);
			}
			
		}
		//paint bomb
		for(int i=0;i<b.size();++i) {
			if(b.get(i).life>0) {
				g.drawImage(picture, b.get(i).x, b.get(i).y, 30, 30, this);
			}
			b.get(i).liveDown();
			if(b.get(i).life==0) {
				b.remove(i);
			}
		}
	}
	public MyPanel(){
		//initial my Tank
		hero=new Hero(500,300);	
		//initial enemy Tank
		for(int i=0;i<etsNumber;++i) {
			EnemyTank et=new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setDirection(2);
			ets.add(et);
		}
		//initial bomb
		picture=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/xiatangmian.jpg"));
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
	public void isHit(Bullet bs,EnemyTank et) {
		if(bs.getX()>et.getX()&&bs.getX()<et.getX()+30&&bs.getY()>et.getY()&&bs.getY()<et.getY()+30)
		{
			bs.setLive(false);
			et.setLive(false);
			Bomb bo=new Bomb(et.getX(),et.getY());
			b.add(bo);
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
			//if hero hit enemy
			for(int i=0;i<hero.BS.size();++i) {
				if(hero.BS.get(i).isLive())
					for(int j=0;j<ets.size();++j) {
						if(ets.get(j).isLive()) {
							this.isHit(hero.BS.get(i), ets.get(j));
						}
					}
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
			if(hero.BS.size()<5)
			this.hero.fire();
		}
		//this.repaint();
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
					Thread.sleep(100);
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
	int speed=5;
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
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}


}
class Hero extends Tank
{
	private Bullet myBullet=null;
	protected Vector<Bullet>BS=new Vector<Bullet>();
	public void fire() {
		//create bullet
		switch(this.direction)
		{
		case 0:
			myBullet=new Bullet(this.x+10,this.y,0);
			BS.add(myBullet);
			break;

		case 1:
			myBullet=new Bullet(this.x+30,this.y+10,1);
			BS.add(myBullet);
			break;


		case 2:
			myBullet=new Bullet(this.x+10,this.y+30,2);
			BS.add(myBullet);
			break;


		case 3:
			myBullet=new Bullet(this.x,this.y+10,3);
			BS.add(myBullet);
			break;
		}
		for(int i=0;i<BS.size();++i) {
			Thread t=new Thread(myBullet);
			t.start();
		}
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
class EnemyTank extends Tank implements Runnable{

	public EnemyTank(int x, int y) {
		super(x, y);
		this.setColor(1);
		this.speed=1;
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			// {
					switch(this.direction) {
					case 0:
						for(int i=0;i<=20;++i)
						if(this.y>0) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							this.y-=this.speed;break;
						}
						
					case 1:
						for(int i=0;i<=20;++i)
						if(this.x<600) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							this.x+=this.speed;break;
						}
					
					case 2:
						for(int i=0;i<=20;++i)
						if(this.y<500) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							this.y+=this.speed;break;
						}
						
					case 3:
						for(int i=0;i<=20;++i)
						if(this.x>0) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							this.x-=this.speed;break;
						}
						
					}
					
		
			this.direction=(int)(Math.random()*4);
		//	System.out.println(this.direction);
			if(this.isLive()==false	) {
				break;
			}
		}
	}

}
class Bomb{
	int x,y;
	int life=3;
	boolean isLive=true;	
	public Bomb(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void liveDown() {
		if(life>0)
		life--;
	}
}