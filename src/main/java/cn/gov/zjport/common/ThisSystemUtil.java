package cn.gov.zjport.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThisSystemUtil {
    public static String throwIfBlank(String message,String target){
        if(target==null||(target.trim()).length()==0){
            throw new ThisSystemException(message);
        }
        return target;
    }

    public static String $(String message,String target){
        return throwIfBlank(message,target);
    }

    public static void assertNotNull(String message,Object o){
        if(o==null){
            throw new ThisSystemException(message);
        }
    }

    public static void assertNull(String message,Object o){
        if(o!=null){
            throw new ThisSystemException(message);
        }
    }

    public static void assertEquals(String message,Object a,Object b){
        if(a==null?a!=b:!a.equals(b)){
            throw new ThisSystemException(message);
        }
    }

    public static void assertNotEquals(String message,Object a,Object b){
        if(a==null?a==b:a.equals(b)){
            throw new ThisSystemException(message);
        }
    }

    public static void assertTrue(String message,Boolean b){
        if(!b){
            throw new ThisSystemException(message);
        }
    }

    public static void assertFalse(String message,Boolean b){
        if(b){
            throw new ThisSystemException(message);
        }
    }


    public static void assertPatterMatch(String message,String reg,String target){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(target);
        if(!matcher.matches()){
            throw new ThisSystemException(message);
        }
    }


    public static int parseInt(String target,int defaultValue){
        try{
            return Integer.parseInt(target.trim());
        }catch (Exception e){
            return defaultValue;
        }
    }

    public static String uuid(){
        String uuid = UUID.randomUUID().toString();
        char[] cs = new char[32];
        char c = 0;
        for(int i=uuid.length(),j=0;i-->0;){
            if((c=uuid.charAt(i))!='-'){
                cs[j++] = c;
            }
        }
        return new String(cs);

    }

    //md5加密
    public static String md5(String inputStr){
        BigInteger bigInteger = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
            bigInteger = bigInteger.abs();
        }catch(Exception e){
            e.printStackTrace();
        }
            return bigInteger.toString(16);
    }


    public static void main(String[] args) {
        //System.out.println(md5("123"));
        for(int i=10;i-->0;){
            String uuid = uuid();
            System.out.println(uuid);
        }

    }

}
