package p7;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,String> map= new HashMap();
        map.put("1","2");
//        map.put(null,"2");
        map.put("3",null);
//        map.put(null,null);
        System.out.println(map.containsKey(null));
    }
}
