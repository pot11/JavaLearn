package DDNS.p;

import java.util.ArrayList;
import java.util.Comparator;

public class XXX1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        });
//        arrayList.sort(new A());
        System.out.println(arrayList);

    }
}

