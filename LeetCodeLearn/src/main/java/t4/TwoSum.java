package t4;
//两数之和
public class TwoSum {
    public static void main(String[] args) {
//        method1();
        System.out.println(method2());
    }

    private static void method1() {
        int nums[] = {2,7,11,15};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1 ; j < nums.length; j++) {
                if (nums[i] + nums[j] == 9){
                    System.out.println(i + "-----" + j);
                }
            }
        }
    }

    /**
     * 双指针
     */
    private static String method2() {
        int nums[] = {2,7,11,15};
        int i=0, j=nums.length-1;
        int target = 9,sum = 0;
        while (i<j){
            sum = nums[i] + nums[j];
            if (sum == target){
               return i + "---" + j ;
            }else if (sum < target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }


}
