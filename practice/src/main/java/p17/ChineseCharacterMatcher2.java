package p17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChineseCharacterMatcher2 {
    public static void main(String[] args) {
        String inputString = "青霉素类";
        String chinesePattern = "青霉素类抗生素|其他食物过敏源|其他药物过敏源";

        if (fuzzyMatch(inputString, chinesePattern)) {
            System.out.println("匹配成功！");
        } else {
            System.out.println("匹配失败！");
        }
    }

    private static boolean isMatch(String inputString, String chinesePattern) {
        // 将中文模式转换为正则表达式
        String regex = ".*(" + convertToRegex(chinesePattern) + ").*";

        // 使用正则表达式进行匹配
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);

        return matcher.find();
    }

    private static String convertToRegex(String chinesePattern) {
        // 将中文模式中的汉字转换为正则表达式的形式（匹配任意汉字）
        String regex = chinesePattern.replaceAll("([\u4E00-\u9FA5])", ".*$1.*");

        // 在汉字之间添加匹配相同字符的条件
        regex = regex.replaceAll(".*?([\\u4E00-\\u9FA5]).*?\\1.*?", ".*");



        return regex;
    }


    private static boolean customMatch(String inputString, String chinesePattern) {
        // 遍历字符串
        for (int i = 0; i < inputString.length() - 1; i++) {
            String pair = inputString.substring(i, i + 2);

            // 判断是否在中文模式中出现
            if (chinesePattern.contains(pair)) {
                return true;
            }
        }

        return false;
    }

    public static boolean fuzzyMatch(String s1, String s2) {
        for (int i = 0; i < s1.length() - 1; i++) {
            String subStr = s1.substring(i, i + 2);
            if (s2.contains(subStr)) {
                return true;
            }
        }
        return false;
    }
}



