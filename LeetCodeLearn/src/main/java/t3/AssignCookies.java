package t3;

import java.util.Arrays;

//贪心思想 分饼干
public class AssignCookies {
    public static void main(String[] args) {
        int[] grid = {1,3};
        int[] size = {1,2,4};
        System.out.println(findContentChildren(grid, size));
    }

    public static int findContentChildren(int[] grid, int[] size) {
        if (grid.length == 0 || size.length == 0) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int count = 0;//满足的孩子个数
        int i=0,j=0;
        while (i < grid.length && j<size.length){
            if (grid[i] <= size[j]){
                i++;
            }
            j++;
        }
        count = i;
        return count;
    }
}
