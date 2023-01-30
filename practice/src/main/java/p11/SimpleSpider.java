package p11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class SimpleSpider {
    public static void main(String[] args) throws Exception {
        // 要爬取的网站地址
        String url = "http://114.xixik.com/12shichen/";

        // 打开网站
        URL site = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()));

        // 读取网站源代码
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }

        // 关闭流
        in.close();
    }
}
