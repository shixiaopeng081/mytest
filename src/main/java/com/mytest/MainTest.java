package com.mytest;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.*;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by shixi  on 2018/12/28
 */
public class MainTest {

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}";
    public static final String REGEX_WECHAT = "[a-zA-Z]{1}[-_a-zA-Z0-9]{5,19}";
    public static final String REGEX_WECHAT1 = "[a-zA-Z0-9_-]{5,19}";

    public static void main(String[] args) {

        short a = 128;
        byte b= (byte)a;
        System.out.println(a);
        System.out.println(b);



        String content = "fdsfds=fdsafdsa&sssss=wq13718348719";
        Pattern p = Pattern.compile(REGEX_WECHAT);
        Matcher m = p.matcher(content);
        String paramStr = new String(content);
        while (m.find()) { //一定需要先查找再调用group获取电话号码
            paramStr = paramStr.replaceAll(m.group(), m.group().substring(0, 3) + "****"+m.group().substring(6));
            System.out.println(paramStr);
        }

        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(7);
        Date date = Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDateTime plusDays = localDateTime.plusDays(1);

        System.out.println(localDateTime.minusDays(1));
        System.out.println(plusDays);
        System.out.println(localDateTime);
        System.out.println(localDate.atTime(0,0));
        System.out.println(date);
        System.out.println(date.getTime());

        regexMobile("1&fdsfdsa=fdsafdsa&sssss=wq");


        // 集合1
        List<SkillUpgrade> lists = new ArrayList<>();
        SkillUpgrade s = new SkillUpgrade();
        s.setLv(1);
        s.setAppearNum(100);
        lists.add(s);
        SkillUpgrade s2 = new SkillUpgrade();
        s2.setLv(2);
        s2.setAppearNum(200);
        lists.add(s2);
        // 集合1
        List<SkillUpgrade> listx = new ArrayList<>();
        SkillUpgrade x = new SkillUpgrade();
        x.setLv(1);
        x.setSelectNum(1100);
        listx.add(x);
        SkillUpgrade x2 = new SkillUpgrade();
        x2.setLv(1);
        x2.setSelectNum(1200);
        listx.add(x2);
//        // 把list转map,{k=lv,vaule=并为自身}  . SkillUpgrade->SkillUpgrade或Function.identity()
//        Map<Integer, SkillUpgrade> map = listx.stream()
//                .collect(Collectors.toMap(SkillUpgrade::getLv, SkillUpgrade -> SkillUpgrade));
//        System.out.println("map:="+map);
//        // 合并
//        lists.forEach(n -> {
//            // 如果等级一致
//            if (map.containsKey(n.getLv())) {
//                SkillUpgrade obj = map.get(n.getLv());
//                // 把数量复制过去
//                n.setSelectNum(obj.getSelectNum());
//            }
//        });
//        System.out.println("lists:="+lists);
        // 重复问题
//        Map<Integer, SkillUpgrade> keyRedo = listx.stream()
//                .collect(Collectors.toMap(SkillUpgrade::getLv, Function.identity(), (key1, key2) -> key2));
//        System.out.println("keyRedo:="+keyRedo);
//        // 方式二：指定实例的map
//        Map<Integer, SkillUpgrade> linkedHashMap = listx.stream().collect(Collectors.toMap(SkillUpgrade::getLv,
//                SkillUpgrade -> SkillUpgrade, (key1, key2) -> key2, LinkedHashMap::new));


//        MainTest mainTest = new MainTest();
//        mainTest.sss();
    }

    private static String regexMobile(String content){
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher m = p.matcher(content);
        String paramStr = new String(content);
        while (m.find()) { //一定需要先查找再调用group获取电话号码
            paramStr = paramStr.replaceAll(m.group(), "*******"+m.group().substring(7));
        }
        return paramStr;
    }

    @Data
    private static class SkillUpgrade {

        int lv;

        int selectNum;

        int appearNum;
    }


    public void  sss() throws ArithmeticException{

        try {  //要监视的代码
            int i = 9/0;
        }
        catch (ArithmeticException exc) {  //捕获除数为0这个异常
            throw new ArithmeticException("除数为 0 ");
        }
    }
}
