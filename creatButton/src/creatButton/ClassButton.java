
package creatButton;
//import java package
import java.awt.*;
import javax.swing.*;
/**
 * @author ts
 *
 */
public class ClassButton extends JFrame {
	private static final int width=600,height=600;
	/**
	 * @param args
	 */
	/*需要的swing组件添加在了这里*/
	private JFrame jf=null;
	JButton jb1=null;
	public static void main(String[] args) {
		
		ClassButton cb=new ClassButton();
	 
	}
	public ClassButton()//构造函数
	{
		// TODO 自动生成的方法存根
		//jFrame 是一个顶层容器，里面可以添加其他swing组建的类
		this.jf=new JFrame();
		this.jb1=new JButton("我是按钮");
		//框架设置
		jf.setTitle("tangstone's first window");
		jf.setSize(width, height);		
		jf.setLocation(100, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		//按键设置
		jf.add(jb1);
	}
			
}
