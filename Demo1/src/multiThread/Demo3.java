package multiThread;

public class Demo3 implements Runnable  {  
	private Object lock = new Object();  
	private int count;  

	public static void main(String[] args) {  
		Demo3 abc = new Demo3();  
		new Thread(abc,"A").start();  
		new Thread(abc,"B").start();  
		new Thread(abc,"C").start();  
	}  
	private void scream() {
		System.out.print("哇啦哇啦     ");  
	}
	public void run() {  
		for (int i = 0; i < 10; i++) {  
			synchronized (lock) {  
				while (true) {  
					if (count % 3 == (int)(Thread.currentThread().getName().charAt(0))%3) {  
						this.scream();
						System.out.println("Count:" + i + ",Thread-Name:"  + Thread.currentThread().getName());  
						count++;  
						lock.notifyAll();  
						break;  
					} else {  
						try {  
							lock.wait();  
						} catch (InterruptedException e) {  
							e.printStackTrace();  
						}  
					}  
				}  
			}  
		}  
	}  
}  
