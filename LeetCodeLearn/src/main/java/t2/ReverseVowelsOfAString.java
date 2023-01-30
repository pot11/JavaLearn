package t2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ReverseVowelsOfAString {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public static void main(String[] args) {
//        reverseVowels("leetcode");
        reverseVowels2("leetcode");
    }

    private static void reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j){
            if (vowels.contains(chars[i]) && vowels.contains(chars[j])){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }else if (vowels.contains(chars[i]) && !vowels.contains(chars[j])){
                j--;
            }else if (!vowels.contains(chars[i]) && vowels.contains(chars[j])){
                i++;
            }else {
                i++;
                j--;
            }
        }
        System.out.println("------------" + String.valueOf(chars));
    }

    private static void reverseVowels2(String s) {
        char[] chars = new char[s.length()];
        int i = 0;
        int j = chars.length - 1;
        while (i < j){
            char ci = chars[i];
            char cj = chars[j];
            if (!vowels.contains(chars[i])){
                chars[i++] = ci;

            }else if (vowels.contains(chars[i]) && !vowels.contains(chars[j])){
                j--;
            }else if (!vowels.contains(chars[i]) && vowels.contains(chars[j])){
                i++;
            }else {
                i++;
                j--;
            }
        }


//        System.out.println(new String(chars1));
    }
}
