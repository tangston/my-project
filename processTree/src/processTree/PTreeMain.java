package processTree;
import java.io.*;
import java.util.*;
import binaryTree.*;

public class PTreeMain {
	public static void main(String[] args)throws Exception
	{
		BinaryTree processTree=new BinaryTree();
		String processName, processID, parentProcessID;
		//file process
		String rootPath="D:\\proc"; 
		StringBuffer  currentPath = new StringBuffer("D:\\proc");

		ProcessInformation pi[]=new ProcessInformation[1024];



		String[] FileList=FileProcess.getFileName(rootPath);


		for(int i=0;i<FileList.length;++i) {
			//System.out.println(FileList[i].charAt(0));
			if(FileList[i].charAt(0)>='0'&&FileList[i].charAt(0)<='9') {	
				String text ;
				char[]  text1= new char[5000]; 

				try {
					FileReader fr = new FileReader(rootPath+ "\\" + FileList[i]+"\\status");  
					fr.read(text1);
					text= String.valueOf(text1);
				//	System.out.println(text);
					processName=FileProcess.getStatus(text, "name");
					processID=FileProcess.getStatus(text, "pid");
					parentProcessID=FileProcess.getStatus(text, "ppid");
					pi[i]=new  ProcessInformation(processName, StringToNumber.stringToNumber(processID), StringToNumber.stringToNumber(parentProcessID));
					pi[i].show();
					fr.close();
				} catch (Exception e) {
					//System.out.println((i+1)+"happened an exception");
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}

		//tree create
		for(int i=0;i<FileList.length;++i) {
			  if(FileList[i].charAt(0)>='0'&&FileList[i].charAt(0)<='9') {
				  processTree.insert( pi[i].getProcessID(), pi[i].getParentProcessID(), pi[i].getProcessName());
			  }
		  }
		
		//print
		processTree.preOrderTraverse();

	
	}
	
}
class KMP {
	//返回索引号，从1开始
	public static int kmp(String str, String dest,int[] next){//str文本串  dest 模式串
		for(int i = 0, j = 0; i < str.length(); i++){
			while(j > 0 && str.charAt(i) != dest.charAt(j)){
				j = next[j - 1];
			}
			if(str.charAt(i) == dest.charAt(j)){
				j++;
			}
			if(j == dest.length()){
				return i-j+1;
			}
		}
		return 0;
	}
	public static int[] kmpnext(String dest){
		int[] next = new int[dest.length()];
		next[0] = 0;
		for(int i = 1,j = 0; i < dest.length(); i++){
			while(j > 0 && dest.charAt(j) != dest.charAt(i)){
				j = next[j - 1];
			}
			if(dest.charAt(i) == dest.charAt(j)){
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}

class FileProcess
{
	/*public FilenameFilter filter=new FilenameFilter() {

	}*/
	static public String getStatus(String text,String name) {
		StringBuffer status = new StringBuffer();
		String splitFlag=":";
		int [] next=KMP.kmpnext(name);
		int index=KMP.kmp(text, name, next);

		int i;
		if(index!=0) {
			for(i=index;i<=index+10;i++) {
				if(text.charAt(i)==splitFlag.charAt(0))	
					break;			
			}
			i++;//skip divide signal
			while(text.charAt(i)!='\n'&&text.charAt(i)!=-1) {
				status.append(text.charAt(i));
				i++;
			}
			//System.out.println(status);
		//	status.replace(status.length(), status.length(), null);
			return status.toString().trim();

		}
		return null;	
	}
	public static String [] getFileName(String path)
	{
		File file = new File(path);
		String [] fileName = file.list();
		return fileName;
	}
	public static void getAllFileName(String path,ArrayList<String> fileName)
	{
		File file = new File(path);
		File [] files = file.listFiles();
		String [] names = file.list();
		if(names != null)
			fileName.addAll(Arrays.asList(names));
		for(File a:files)
		{
			if(a.isDirectory())
			{
				getAllFileName(a.getAbsolutePath(),fileName);
			}
		}
	}
}

/**
 * 
 * 
 * 
 * 
 * @author ts
 *
 */
class ProcessInformation{
	private String ProcessName;
	private int ProcessID;
	private int ParentProcessID;
	public ProcessInformation(String processName, int processID, int parentProcessID) {
		this.ProcessName = processName;
		this.ProcessID = processID;
		this.ParentProcessID = parentProcessID;
	}
	ProcessInformation(){
		this.ProcessName = null;
		this.ProcessID = 0;
		this.ParentProcessID = 0;
	}
	public String getProcessName() {
		return ProcessName;
	}
	public void setProcessName(String processName) {
		ProcessName = processName;
	}
	public int getProcessID() {
		return ProcessID;
	}
	public void setProcessID(int processID) {
		ProcessID = processID;
	}
	public int getParentProcessID() {
		return ParentProcessID;
	}
	public void setParentProcessID(int parentProcessID) {
		ParentProcessID = parentProcessID;
	}
	public void show() {
		System.out.println("1ProcessName:"+this.getProcessName());
		System.out.println("1ProcessID:"+this.getProcessID());
		System.out.println("1ParentProcessID:"+this.getParentProcessID());
	}

}
class StringToNumber {  
    public static int stringToNumber(String str) {  
        //首先判断空值  
        if(str == null) {  
            return 0;  
        }  
        //去掉空格的情况  
        str = str.trim();  
        if(str.length() == 0)  
            return 0;  
        //正负数标识  
        int sign = 1;  
        int index = 0;  
        if(str.charAt(index) == '+')  
            index++;  
        else if(str.charAt(index) == '-') {  
            index++;  
            sign = -1;  
        }  
        //取得数字部分，遇到溢出和非数字退出  
        long number = 0;  
        for(; index < str.length(); index++) {  
            if(str.charAt(index) < '0' || str.charAt(index) > '9')  
                break;  
            number = number * 10 + (str.charAt(index) - '0');  
            if(number >= Integer.MAX_VALUE)  
                break;  
        }  
        if(number * sign <= Integer.MIN_VALUE)  
            return Integer.MIN_VALUE;  
        if(number * sign >= Integer.MAX_VALUE)  
            return Integer.MAX_VALUE;  
        return (int) number * sign;  
    }  
}  