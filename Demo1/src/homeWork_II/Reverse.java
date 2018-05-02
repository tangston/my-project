package homeWork_II;

public class Reverse {
	private String name="WhatDoesTheFoxSay";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String upsideDown() {
		StringBuffer stb1=new StringBuffer("");
		for(int i=this.name.length()-1;i>=0;--i) {
			if(this.name.charAt(i)>='a'&&this.name.charAt(i)<='z') {
				stb1.append(String.valueOf(this.name.charAt(i)).toUpperCase());
			}
			else if(this.name.charAt(i)>='A'&&this.name.charAt(i)<='Z') {
				stb1.append(String.valueOf(this.name.charAt(i)).toLowerCase());
			}
			else
				stb1.append(this.name.charAt(i));
		}
		return stb1.toString();
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Reverse rs=new Reverse();
		System.out.println(rs.getName());
		System.out.println(rs.upsideDown());
		rs.setName("HelloWorld");
		System.out.println(rs.getName());
		System.out.println(rs.upsideDown());
	}

}
