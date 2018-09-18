package cn.gov.zjport.javastudy;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Sign {

    public static void main(String[] args) {

        final String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMZvScE47f8arz6Oion2Dg9PstgewLYLvr+NSHDOcMZx1CL8Si1UGgVL6g57jRpBEcmHE8CfdgP1hIwccD+AbopHJzIxe0O8iJDQmV8SisgFq6vC5P/Pd44qCqeAmtNjPw23rivayQpD36BUd7YKxEV56Des+3sLJePLU4zH5/7xAgMBAAECgYAT2bYrGiLUzjqRq3i4bGDjrzlY3Vqx22LtjpickEo/z8tE5LAW8L7ZoMp9QGbRJYk9+8FCF7Gam8jyqzWfZJ2qEm7bY/m/RZxPUk4zW0j645zIYgF7RgZK3cyEBUFUGldE3vXIy+DYQnGX2rzmYfOUscttW3JOfZVav6lRPoXvAQJBAOhERcWGSamNWRjRviDZr2DyCNjBKVqkmu+biFb8etegZslro31P6/hFZxfK2pwPtripeaXGBrPCokbsxMV4spkCQQDatgZlMjvbPKBD00c7PtWdFaJWTw2cl4/i1YNeg+Vxt1x+8mpPqgBVhsQUWRgUgWEXxWniXEVU5QoHcdXqub4ZAkEA05R9ynWN3Lo6E3XdMKecLz/L90femAeia+rOxA6zCIHBoHJBOAH5/uuaAf50Lf3SgV1Ax1Yg/NesY9eDWC+e4QJBALK8CuHseYojM336Tb4XDY9APNh35lHQcqAXiTJWa83Q4WBFT6gm7/r1FYzjepBXYzd/95YrfeVxAA8xcnZOsRECQE4CLx9/E9Y+woAXtM8SihQqFGHwyIXlulgHXCaY+a26ZfhT/rmpwGyEqFTFqHBJyqQ+TFo9NcnfXIp2f3qz7qM=";
        final String signType = "RSA";

        Map<String, Object> mp = new HashMap<String, Object>();
        /******以下自行加载数据 *********/
        mp.put("operator", "Mike@demo.com");
        mp.put("orderNum", "dec0b9a4d3e44a768eb5473ed26f3d54");
        mp.put("userId", "3202001000000030");

        String value = rsaSign(mp, privateKey, signType);
        System.out.println(value);
    };


    /**
     * RSA签名
     * @author
     * @param params 参数，没有值，包括null和空串的参数，不要放入参数map中
     * @param signType签名方式，取值为：RSA256和其他。
     * @param privateKey 私钥
     * @return 签名后字符串
     **/
    public static String rsaSign(Map<String, Object> params, String privateKey, String signType)
    {
        // 获取待签名字符串
        String content = getSignData(params, true);
        //System.out.println(content);
        // 进行签名
        return sign(content, privateKey, signType);
    };

    /**
     * 将Map组装成待签名数据。 待签名的数据必须按照一定的顺序排列，没有值，包括null和空串的参数，不要放入参数map中
     * @param params 参数
     * @return 签名Data
     **/
    public static String getSignData(Map<String, Object> params, boolean ifsort) {

        StringBuffer content = new StringBuffer();

        List<String> keys = new ArrayList<String>(params.keySet());
        if (ifsort) {
            Collections.sort(keys);
        }

        int p = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            if ("sign".equals(key)) {
                continue;
            }
            if ("signType".equals(key)) {
                continue;
            }
            Object obj = params.get(key);
            if ( obj == null ) {
                continue;
            }

            String value = "";
            if (obj instanceof String){
                value = (String) params.get(key);
            }else {
                value = String.valueOf(obj);
            }

            if (value != null) {
                content.append((p == 0 ? "" : "&") + key + "=" + value);
            } else {
                content.append((p == 0 ? "" : "&") + key + "=");
            }
            p = 1;
        }

        return content.toString();
    };

    /**
     * RSA签名
     * @param content 待签名数据
     * @param privateKey 商户私钥
     * @param signType sign method, rsa, rsa 256
     * @return 签名值
     ***/
    public static String sign(String content, String privateKey, String signType)
    {
        String charset = "utf-8";
        try
        {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(base64decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            java.security.Signature signature = null;
            if (!"RSA256".equals(signType)) {
                signature = java.security.Signature.getInstance("SHA1WithRSA");
            } else {
                signature = java.security.Signature.getInstance("SHA256WithRSA");
            }

            signature.initSign(priKey);
            signature.update(content.getBytes("utf-8"));
            byte[] signed = signature.sign();
            return base64encode(signed);
            //return Base64.encode(signed);
        }
        catch (Exception e)
        {
            System.out.println("Exception when signing: " + e);
        }

        return "";
    };

    private static String base64encode(byte[] myBytes){
        return Base64.getEncoder().encodeToString(myBytes);
    };
    private static byte[] base64decode(String myString){
        return Base64.getDecoder().decode(myString);
    };
};