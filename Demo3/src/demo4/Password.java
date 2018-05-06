package demo4;
import java.io.*; 
public class Password {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		Game g=new Game();
	}

}
class Game{

	public Game() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//包装升级in方法
		String password = ""; 
		boolean isPassed = false; 
		for (int i = 0; i < 5; i++) 
		{ 
			System.out.println("请输入密码:");
			password = br.readLine();
			if (password.equals("123456"))
			{ 
				System.out.println("恭喜你进入游戏"); 
				isPassed = true; break;
			}
		} 
		if (!isPassed) 
		{ 
			System.out.println("密码错误，游戏结束"); 
			System.exit(0);
		}
	}
}