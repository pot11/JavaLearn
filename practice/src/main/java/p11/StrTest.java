package p11;

public class StrTest {
    public static void main(String[] args) {
        String s = "";
        String s2 = "s";
        if (s.length() >0){
            String substring = s.substring(0, s.length() - 1);
            System.out.println(substring);
        }
    }
}
