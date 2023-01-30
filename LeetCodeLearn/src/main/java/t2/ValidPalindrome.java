package t2;


//回文字符串
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abcba"));
    }

    private static Boolean validPalindrome(String s) {
        //for循环判断是否全部对称相等，一旦发现有一个不对称想同，for循环就没用了。
        for (int i=0 ,j = s.length()-1 ; i < j ; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                //左或右 减一 双指针判断
                return isPalindrome(s, i , j-1) || isPalindrome(s, i+1 , j);
            }
        }
        return true;
    }

    private static Boolean isPalindrome(String s, int i , int j) {
        while (i <= j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
