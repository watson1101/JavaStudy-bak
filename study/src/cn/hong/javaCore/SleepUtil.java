package cn.hong.javaCore;

import java.util.concurrent.TimeUnit;

public class SleepUtil {
	public static final void second(long seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
