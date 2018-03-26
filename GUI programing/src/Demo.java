import javax.swing.*;
import java.awt.*;//abstract windows tool
public class Demo extends JFrame
{
	JSplitPane jsp;
	JList jList;
	public static void main(String[] args) 
	{
		// TODO 自动生成的方法存根

	}
	public Demo()
	{
		//创建组件
		String []word={"boy","girl","bird"};
		jList =new JList(word);
		
	}

}
