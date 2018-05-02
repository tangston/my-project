package homeWork_II;
import java.util.*; 
import java.io.*; 
import java.text.DecimalFormat;
public class RedPacket {
	public void givePacket(int money1,int number) {
		int i;
		double money= money1;
		for(i=1;i<=number-1;++i) {
			double mm=(Math.random()*money);
			//System.out.println(mm);
			System.out.println("第"+i+"个人抢到的金额："+new DecimalFormat("#.##").format(mm));
			money-=mm;
		}
		System.out.println("第"+i+"个人抢到的金额："+new DecimalFormat("#.##").format(money));
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int money;
		int number;
		  Scanner sc = new Scanner(System.in);     
		  System.out.println("请输入您要发的红包总金额：");    
		  money=sc.nextInt();
		  System.out.println("请输入红包的份数：");  
		  number=sc.nextInt();
		  RedPacket rp=new  RedPacket();
		  rp.givePacket(money, number);
		}
		

	}
