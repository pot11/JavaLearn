package p17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChineseCharacterMatcher {
    public static void main(String[] args) {
        String inputString = "抗世界";
        String inputString2 = "世界22";

        // 要匹配的汉字
        String chinesePattern = ".*世界.*";
//        String chinesePattern = "xxx世界";

        // 使用正则表达式进行模糊匹配
        Pattern pattern = Pattern.compile(chinesePattern);
        Matcher matcher = pattern.matcher(inputString2);

        // 查找匹配
        while (matcher.find()) {
            System.out.println("找到匹配：" + matcher.group());
        }



////        String inputString2 = "抗青霉素";
//        String inputString2 = "青霉素";
//
//        // 要匹配的汉字
////        String chinesePattern2 = "青霉素";
//        String chinesePattern2 = "抗青霉素";
//        System.out.println(inputString2.contains(chinesePattern2));


    }
}

//    String inputString = "xxx世界111";
//    String chinesePattern = "抗世界的神";