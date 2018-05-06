package demo4;

import java.io.*;
import java.util.*;
import java.util.Map.Entry; 
public class  CountWord
{ 
	public static void display(File file)throws Exception{
		 BufferedReader br = new BufferedReader(new FileReader(file));
		 String line = null;
		 //定义一个map集合保存单词和单词出现的个数
		 TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
		 //读取文件
		 while((line=br.readLine())!=null)
		 {	    
		    line.toLowerCase();
		    String reg1 = "\\s+";
		    String reg2 ="\\w+";
		    //将读取的文本进行分割\\s表示   空格,回车,换行等空白符,+号表示一个或多个的意思
		    String x3x="呵呵";
		    String str[] = line.split(reg1);
		    for(String s: str){
		     if(s.matches(reg2)) // \\w+是^\w中\w表示字符类（包括大小写字母，数字）
		    	 {
		       //判断集合中是否已经存在纯英文单词，如果存在则个数加一，否则将单词添加到        //集合中，且个数置为1
		       if(!tm.containsKey(s)){
		         tm.put(s,1);
		      }else{
		         tm.put(s,tm.get(s)+1);
		         }
		    }
		  }
		}
		 for(Iterator<Entry<String, Integer>> it=tm.entrySet().iterator();it.hasNext();) {
			 System.out.println(it.next());
		 }
		
		}
	public static void main(String[] args) throws Exception
	{
		File f=new File("D:\\project\\github\\my-project\\Demo3\\src\\demo4\\1.txt");
		display(f);
	}

}
