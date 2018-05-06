package demo3;
public class test {
	
	public static void main(String[] args) {
		int a=0;
		while(a<5) {
			switch(a) {
			case 1:System.out.println("case 0:"+a);
			case 5:{System.out.println("case 3:"+a);a+=2;System.out.println("case 3:"+a);}
			case 0:System.out.println("case 1:"+a);;
			case 4:{System.out.println("case 2:"+a);a+=3;}
			default:a+=5;
			}
		}
		int ac=0;
		char c='0';
		double r=9.8;
		String bc="aa";
		String b=ac+bc;
		System.out.println(b.length());
	}
		
}