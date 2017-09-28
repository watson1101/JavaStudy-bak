package cn.hong.javaCore;

/**
 * From java并发编程的艺术
 * 
 * @author Administrator 2017年8月3日下午5:40:53
 */
public class JC170803MultiThreadDaemon {

	public static void main(String[] args) {
		Thread th = new Thread(new JC170803MultiThreadDaemonRunner(), "runner");
		th.setDaemon(true);//set as daemon thread
		th.start();
	}
}
