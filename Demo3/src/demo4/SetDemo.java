package demo4;
import java.util.*; 
public class SetDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HashSet<Person> hashSet = new HashSet<Person>();
		Person p1 = new Person("tangstone",20); 
		Person p2 = new Person("tangstone",221);
		Person p3 = new Person("tangston",222);
		hashSet.add(p1); 
		hashSet.add(p2);
		hashSet.add(p3); 

		Iterator<Person> it=hashSet.iterator();
		for(;it.hasNext();)
		{ 
			Person pt=it.next();
			System.out.println(" age:"+pt.age +"  name: "+pt.name);
		}
	}

}

class Person{
	String name; 
	int age;
	public Person(String name, int age)
	{ 
		this.name = name; 
		this.age = age; 
	} 
	public int hashCode() { 
		return name.hashCode();
	} 
	public boolean equals(Object  person)
	{ 
		if (this==person ) {		
			return true;
		}
		if(person==null) {
			return false;
		}
		Person p=(Person)person;
		return p.hashCode()==this.hashCode();
	}
}
