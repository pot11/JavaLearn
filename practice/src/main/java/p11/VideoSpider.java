package p11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class VideoSpider {
    public static void main(String[] args) throws Exception {
        // 要爬取的视频网站地址
        String url = "https://www.mlb.com/video";

        // 打开视频网站
        URL site = new URL(url);
        URLConnection connection = site.openConnection();

        // 设置 User-Agent 头，以防止被反爬虫
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");

        // 获取视频数据流
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // 读取视频数据
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            // 将视频数据存储到文件中
            // ...
        }

        // 关闭流
        in.close();
    }
}
