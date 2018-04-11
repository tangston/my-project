package multiThread;
/**
 *	text using UTF-8
 * new 一个对象并产生多个线程计算高斯求和1到100
 * @author tangstone 1605040209
 * 完成日期 2018/4/4 17：10
 *	
 */
public class Sum implements Runnable
{
	
	public static void main(String[] args)
	{
		Sum ts=new Sum();
		
		Cat cat=new Cat(0);
		
		for(int i=0;i<10;++i)
		{
			new Thread(cat).start();
		}
		new Thread(ts).start();
		
	}
	
	@Override
	public void run() {
		while(Cat.processFinish !=10);
		System.out.println("main sum= "+Cat.sum);
	}
	
	
}

class Cat implements Runnable 
{
	public  static int sum=0;
	public  static int processFinish=0;
	int num1=0;
	public Cat(int num)
	{
		this.num1=num;
	}
	 public  void  count()
	{
		
		 synchronized(this)
			{		for(int i=1;i<=10;++i)
				{
					num1+=1;
					sum+=num1;
				}
				System.out.println("Cat No. "+(num1)/10+" \'s sum= "+sum);
				processFinish++;
			}
	}
	@Override
	public   void run()
	{		
		count();		
	}
	
}