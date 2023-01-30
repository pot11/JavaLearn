package p10;

import com.alibaba.fastjson.JSONArray;

public class Main2 {
    public static void main(String[] args) {
//        Long[] a = new Long[]{1l,2l,3l,4l,5l};
//        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(a);
//        System.out.println(jsonArray.toString());
        try {
            throw new RuntimeException("aa");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("走了");

    }
}
