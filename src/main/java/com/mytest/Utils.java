package com.mytest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shixi  on 2018/11/29
 */
public class Utils {
    public static void main(String[] args) {
        //时间戳毫秒转LocalDateTime
//        LocalDateTime localDateTime = new Date(1535444725000L).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
//
//        System.out.println(localDateTime);
//
//        System.out.println(getRemainSecondsOneDay(new Date()));
        listTest();
    }

    public static Integer getRemainSecondsOneDay(Date currentDate) {
        //获取当前时间，到今晚12点的剩余秒
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return (int) seconds;
    }

    public static void listTest(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);




        for(int i = 1;i < 3 ;i ++){
            List<Integer> listNew = new ArrayList<>();
            listNew.addAll(list1);
            listNew.removeAll(list2);
            listNew.removeAll(null);
            System.out.println(list1);

        }
    }

}
