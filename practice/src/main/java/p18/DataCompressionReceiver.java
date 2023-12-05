//package p18;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.util.zip.GZIPInputStream;
//
//public class DataCompressionReceiver {
//
//    public static void main(String[] args) {
//        // 假设这是从发送端接收到的压缩后的 JSON 数据
//        byte[] compressedData = "..."; // 从实际应用中获取压缩后的数据
//
//        // 解压 JSON 数据
//        String jsonData = decompress(compressedData);
//
//        System.out.println("Decompressed Data: " + jsonData);
//    }
//
//    private static String decompress(byte[] compressedData) {
//        try {
//            GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(compressedData));
//            byte[] buffer = new byte[1024];
//            StringBuilder result = new StringBuilder();
//
//            int length;
//            while ((length = gzipInputStream.read(buffer)) > 0) {
//                result.append(new String(buffer, 0, length, "UTF-8"));
//            }
//
//            gzipInputStream.close();
//            return result.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//}
