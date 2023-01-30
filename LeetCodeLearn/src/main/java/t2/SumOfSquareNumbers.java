package t2;
//两数平方和
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        judgeSquareSum();

    }

    private static Boolean judgeSquareSum() {
        int target = 5;
        int i = 0 ;
        int j = (int)Math.sqrt(5);
        while (i <= j){
            int sum = i * i + j * j;
            if (sum == target){
                System.out.println(i + "---" + j);
                return true;
            }else if (sum < target){
                i ++;
            }else {
                j --;
            }
        }
        return false;
    }
}
