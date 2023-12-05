package p18;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 *
 * 使用Gzip压缩大文本json字符串
 */
public class DataCompressionSender {

    public static void main(String[] args) {
        // 假设这是要发送的 JSON 数据
        String jsonData = "{\"id\": 1, \"name\": \"John\", \"age\": 25}";

        // 压缩 JSON 数据
        byte[] compressedData = compress(jsonData);

        // 在实际应用中，你会将 compressedData 发送到接收端
        System.out.println("Compressed Data: " + new String(compressedData));

        // 解压 JSON 数据
        String receiverJsonData = decompress(compressedData);

        System.out.println("Decompressed Data: " + receiverJsonData);
    }

    /**
     * 压缩
     * @param data
     * @return
     */
    private static byte[] compress(String data) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(baos);

            gzipOutputStream.write(data.getBytes("UTF-8"));
            gzipOutputStream.close();

            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }


    /**
     * 解压缩
     * @param compressedData
     * @return
     */
    private static String decompress(byte[] compressedData) {
        try {
            GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(compressedData));
            byte[] buffer = new byte[1024];
            StringBuilder result = new StringBuilder();

            int length;
            while ((length = gzipInputStream.read(buffer)) > 0) {
                result.append(new String(buffer, 0, length, "UTF-8"));
            }

            gzipInputStream.close();
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
