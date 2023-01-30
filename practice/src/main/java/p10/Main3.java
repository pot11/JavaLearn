package p10;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("code1","诊断一");
        map.put("code2","诊断一编码");
        map.put("code3","诊断二");
        map.put("code4","诊断二编码");
        String diagnoseNameStr = JSONObject.toJSONString(map);
        System.out.println(diagnoseNameStr);
//        List<String> strings = new ArrayList<>();
//        strings.add("001000148");
//        strings.add("001000060");
//        strings.add("001000230");
//        strings.add("50007984");
//        strings.add("001000233");
//        strings.add("001000148");
//        String s = JSONObject.toJSONString(strings);
//        List<String> strings1 = JSONObject.parseArray(s, String.class);
//        String drugNames = "";
        String diagnoseName = "";
        Map mapTypes = JSON.parseObject(diagnoseNameStr);
        System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
        for (Object obj : mapTypes.keySet()){
            diagnoseName += obj.toString() + ",";
            System.out.println("key为："+obj+"值为："+mapTypes.get(obj));
        }
        System.out.println(diagnoseName);


    }
}
