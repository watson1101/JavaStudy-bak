package com.hong.dogwoodDownload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUtils {
	// 目标链接字符串
	private String[] urlString;
	// 目标文件的格式
	private String targetType;
	// 存放文件路径
	private File rootDir;

	public String[] getUrlString() {
		return urlString;
	}

	public void setUrlString(String[] urlString) {
		this.urlString = urlString;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public File getRootDir() {
		return rootDir;
	}

	public void setRootDir(File rootDir) {
		this.rootDir = rootDir;
	}

	public DownloadUtils(String[] urlString, String targetType, File rootDir) {
		super();
		this.urlString = urlString;
		this.targetType = targetType;
		this.rootDir = rootDir;
	}

	public DownloadUtils(String[] urlString, String targetType, String rootDir) {
		super();
		this.urlString = urlString;
		this.targetType = targetType;
		this.rootDir = new File(rootDir);
	}

	public DownloadUtils() {
		super();
	}

	/**
	 * 开始下载
	 * 
	 * @throws Exception
	 */
	public void httpDownload() throws Exception {
		validate();
		final String[] urls = urlString;
		HttpURLConnection urlConnection;
		for (int i = 0; i < urls.length; i++) {
			urlConnection = (HttpURLConnection) new URL(urls[i]).openConnection();
			// 开启链接
			urlConnection.connect();
			InputStream inputStream = urlConnection.getInputStream();
			File temp = new File(rootDir, String.format("%02d", i + 1) + "." + targetType);
			if (!temp.exists()) {
				temp.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(temp, true);
			int tem;
			while (-1 != (tem = inputStream.read())) {
				fileOutputStream.write(tem);
				fileOutputStream.flush();
			}
			fileOutputStream.close();
			inputStream.close();

		}

	}

	private void validate() throws Exception {
		if (urlString.length <= 0) {
			throw new Exception("下载路径不能为空!");
		}
		if (null == rootDir || !rootDir.exists() || !rootDir.isDirectory()) {
			throw new Exception("目标文件夹不存在!");
		}

	}
}
