package DDNS.p;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DDNS2 {
    public static void main(String[] args) {
        String apiKey = "efa15645a5f390c7465c5";
        String domain = "pot11.top";

        try {
            URL url = new URL("https://www.namesilo.com/api/dnsListRecords?version=1&type=xml&key=" + apiKey + "&domain=" + domain);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String xmlResponse = response.toString();
                System.out.println(xmlResponse); // 输出XML响应

                // 在这里解析xmlResponse并提取所需的信息
                // 这取决于您想要从响应中获取什么信息

            } else {
                System.out.println("API request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

