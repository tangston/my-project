package innerClass;
/**
 * 
 * @author ts 1605040209
 * finish time :2018 4/4 16:20 
 *	prove the 
 */
public class InnerClass {

	private static final String name="tangstone";
	
	public static void main(String[] args)
	{
		
		 InnerClass ic=new InnerClass();
		 InnerClass.Child icc=ic.new Child();
		 icc.inToFather();
	}
	
	public  InnerClass ()
	{
		System.out.println("Dad is comming");
	}

	class Child
	{
		public   Child ()
		{
			System.out.println("Child is comming");
		}
		public void inToFather()
		{
			System.out.println("Inner class is getting the private name:"+InnerClass.name);//����ֱ�ӷ����ⲿ��˽�г�Ա
		}
	}
}
