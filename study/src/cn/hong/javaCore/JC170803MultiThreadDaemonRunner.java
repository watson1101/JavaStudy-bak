package cn.hong.javaCore;

public class JC170803MultiThreadDaemonRunner implements Runnable {

	@Override
	public void run() {
		try {
			SleepUtil.second(10);
		}finally{
			System.out.println("Daemon thread, finally block running.");
			System.gc();
		}

	}

}
