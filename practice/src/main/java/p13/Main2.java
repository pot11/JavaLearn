package p13;

public class Main2 {
    public static void main(String[] args) {
        FanXinDemo2<Integer> var1 = new FanXinDemo2<>();
        FanXinDemo2<String> var2 = new FanXinDemo2<>();
        var1.setResult(1);
        var2.setResult("xxx");
        System.out.println(var1.getResult());
        System.out.println(var2.getResult());
    }
}
