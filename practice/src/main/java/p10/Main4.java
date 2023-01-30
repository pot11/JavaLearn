package p10;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4 {
    public static void main(String[] args) {
//        method1();
//        method2();
        method3();
    }

    private static void method1() {
        Map map = new HashMap();
        map.put("001000148","地高辛片");
        map.put("001000060","氯化钠注射液");
        map.put("001000230","阿莫西林克拉维酸钾片");
        map.put("50007984","维生素BB注射液");
        String drugStr = JSONObject.toJSONString(map);
        System.out.println(drugStr);
        Map mapTypes = JSON.parseObject(drugStr);
        String drugStrName = "";
        for (Object obj : mapTypes.keySet()){
            drugStrName += map.get(obj).toString() + ",";
            System.out.println("key为："+obj+"值为："+mapTypes.get(obj));
        }
        System.out.println(drugStrName);
    }

    private static void method2() {
        Map map = new HashMap();
        map.put("K07.205","反");
        map.put("R42.x00x004","头晕");
        map.put("J40.x00","支气管炎");

        String drugStr = JSONObject.toJSONString(map);
        System.out.println(drugStr);
        Map mapTypes = JSON.parseObject(drugStr);
        String drugStrName = "";
        for (Object obj : mapTypes.keySet()){
            drugStrName += map.get(obj).toString() + ",";
            System.out.println("key为："+obj+"值为："+mapTypes.get(obj));
        }
        System.out.println(drugStrName);
    }

    private static void method3() {
        List<String> stringList = new ArrayList<>();
        stringList.add(null);
        stringList.add("safda");
        System.out.println(stringList);
    }

}
