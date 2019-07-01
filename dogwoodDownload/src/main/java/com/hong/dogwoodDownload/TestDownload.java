package com.hong.dogwoodDownload;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * https://blog.csdn.net/qq_35530042/article/details/80397164 <br/>
 * 四级词汇乱序版<br/>
 * 知识点: Java网络连接 字节流 文件输入输入   <br/>
 * 分析页面:  四级词汇乱序版 网站:   
 * 
 * http://download.dogwood.com.cn/online/4jlxbx/index.html
 * 
 * 发现都是极具规律性的格式就像这样  
 * 
 * http://download.dogwood.com.cn/online/4jlxbx/01.mp3
 * 
 * 所以直接在基础string 后面添加 MP3编号即可,出于对复用考虑设计成一个下载工具类,方便以后爬虫时复用
 * 
 * @author mc
 *
 */
public class TestDownload {

	public static void main(String[] args) throws MalformedURLException, IOException {
		String base = "http://download.dogwood.com.cn/online/4jlxbx/";
		String[] strings = new String[35];
		for (int i = 1; i <= 35; i++) {
			strings[i - 1] = base + String.format("%02d", i) + ".mp3";
		}
		DownloadUtils downloadUtils = new DownloadUtils(strings, "mp3", "E:\\TempFile");
		try {
			downloadUtils.httpDownload();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
