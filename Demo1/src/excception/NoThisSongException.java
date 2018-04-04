package excception;
/**
 * 制作我的抛出异常和声明异常
 * @author tangstone 1605040209
 * 完成日期 2018/4/4 19：20
 *	text using UTF-8
 */
public class NoThisSongException extends Exception {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Player player=new Player();
		try {
			player.play(-1);
		} catch (NoThisSongException e) {
			 //NoThisSongException方法声明的可能抛出的NoThisSongException异常捕获
			// TODO 自动生成的 catch 块
		//	e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			player.play(11);
		} catch (NoThisSongException e) {
			// TODO 自动生成的 catch 块
		//	e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public NoThisSongException(String str)
	{
		super(str);
	}
	public NoThisSongException()
	{
		super();
	}
}

class Player{
	public void play(int index)throws NoThisSongException
	 //将声明了可能会抛出的异常向外抛出，必须在方法声明中使用throws
	{
		if(index>10)
		{
			throw new NoThisSongException("这首歌序号太大，暂无信息");
		}
		else if(index>10||index<0)
		{
			throw new NoThisSongException("这首歌序号不能为负");
		}
	}
	
}
