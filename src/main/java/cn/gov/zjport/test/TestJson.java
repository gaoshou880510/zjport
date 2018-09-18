package cn.gov.zjport.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJson {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name","gaoshou");
        obj.put("psd","123456");
        String ss = JSON.toJSONString(obj);
        System.out.println(ss);


        JSONArray array = new JSONArray();
        for(int i=0;i<10;i++){
            JSONObject job1 = new JSONObject();
            job1.put("name","gaoshou");
            job1.put("password","123456");
            array.add(job1);
        }

        String bb = JSON.toJSONString(array);
        System.out.println(bb);

        String json = "{\"password\":\"123456\",\"name\":\"gaoshou\"}";
        JSONObject jb = JSON.parseObject(json);
        System.out.println(jb.get("name"));


    }

}
