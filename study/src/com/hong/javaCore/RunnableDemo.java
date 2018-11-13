package cn.hong.javaCore;

/**
 * http://www.runoob.com/java/java-multithreading.html
 * 2017年9月28日下午2:07:48
 */
public class RunnableDemo implements Runnable{
	private Thread t;
	private String threadName;
	
	public RunnableDemo(String threadName) {
		super();
		this.threadName = threadName;
		System.out.println("create thread:"+ threadName);
	}

	@Override
	public void run() {
		System.out.println("running thread:"+ threadName);
		try {
			for(int i =4;i>0;i--){
				System.out.println("线程："+threadName+"暂停，进入挂起");
				Thread.sleep(50);
			}
			System.out.println("Thread " +  threadName + " exiting.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	   public void start () {
		      System.out.println("Starting " +  threadName );
		      if (t == null) {
		         t = new Thread (this, threadName);
		         t.start ();
		      }
		   }
}
