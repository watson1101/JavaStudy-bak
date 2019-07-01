package com.hong.translate;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;

/**
 * https://blog.csdn.net/mumoing/article/details/80466849 <br/>
 * Java爬虫：通过有道翻译获取单词和词组意思 注意：这个不是调用有道翻译的api而是使用爬虫进行信息爬取的。<br/>
  * 经测试有道对于手机网页版的单词的查询并没有设置时间间隔的反爬虫机制（so 速度还是很快的）；<br/>
  * 使用HttpClient-4.5.5进行请求，使用jsoup-1.11.2进行解析。<br/>
 */
public class Test {
	public static void main(String[] args) {
		try {
			String result = getTranslate("google");
			System.out.println("result = " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getTranslate(String word) throws Exception {
		word = word.replaceAll(" ", "+");
		String url = "http://m.youdao.com/dict?le=eng&q=" + word;
		CloseableHttpClient client = HttpClients.createDefault(); // 创建一个可关闭的客户端
		HttpGet hp = new HttpGet(url);// 创建post方法
		// 设置头信息
		hp.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		hp.setHeader("Accept-Encoding", "gzip, deflate");
		hp.setHeader("Accept-Language", "zh-cn");
		hp.setHeader("Connection", "keep-alive");
		hp.setHeader("Cookie",
				"___rl__test__cookies=1526297207528; JSESSIONID=abc8T9npcpuvChUlnzEnw; _yd_newbanner_day=14; OUTFOX_SEARCH_USER_ID_NCOO=1006420317.710858; OUTFOX_SEARCH_USER_ID=1297994902@220.180.56.52");
		hp.setHeader("Host", "m.youdao.com");
		hp.setHeader("Referer", "http://m.youdao.com");
		hp.setHeader("Upgrade-Insecure-Requests", "1");
		hp.setHeader("User-Agent",
				"Mozilla/5.0 (iPhone; CPU iPhone OS 11_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/11.0 Mobile/15E148 Safari/604.1");
		CloseableHttpResponse response = client.execute(hp);
		HttpEntity entity = response.getEntity();
		String web = EntityUtils.toString(entity, "UTF-8");
//		System.out.println("The wab page that return:");
//		System.out.println(web);
		int i = web.indexOf("该词条暂未被收录");
		if (i == -1) {
			Document doc = Jsoup.parse(web, "utf-8");
			Elements con = doc.getElementsByTag("ul");
//			System.out.println("pick up of 'ul' element:");
//			System.out.println(JSON.toJSONString(con));
			String result = con.get(2).text();
			return result;
		} else {
			return "该词条暂未被收录";

		}
	}
}
